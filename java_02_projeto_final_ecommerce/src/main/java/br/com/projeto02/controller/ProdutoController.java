package br.com.projeto02.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto02.domain.model.Produto;
import br.com.projeto02.domain.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoService service;

	@GetMapping
	public List<Produto> listarProdutos() {
		return service.listaTodos();
	}
	
	@GetMapping("/{idProduto}")
	public Produto buscaId (@Valid @PathVariable int idProduto) {
		return service.buscaId(idProduto);
	}
	
	@GetMapping("/codigo/{codigoProduto}")
	public Produto buscaCodigo (@PathVariable String codigoProduto) {
		return service.buscaCodigo(codigoProduto);
	}

	@PostMapping
	public Produto adicionar (@Valid @RequestBody Produto produto) {
		return service.incluir(produto);
	}
	
	@PutMapping("/{id}")
	public Produto atualizar (@PathVariable int id, @RequestBody Produto produto) {
		return service.atualizar(produto, id);
	}
		
	@DeleteMapping("/{id}")
	public void apagar(@PathVariable int id) {
		service.apagar(id);
	}
}
