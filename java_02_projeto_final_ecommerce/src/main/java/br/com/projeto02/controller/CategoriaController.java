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
 
import br.com.projeto02.domain.model.Categoria;
import br.com.projeto02.domain.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
 
	@Autowired
	CategoriaService service;

	@GetMapping
	public List<Categoria> listarCategorias() {
		return service.listaTodos();
	}
	
	@GetMapping("/{idCategoria}")
	public Categoria buscaIdCategoria (@PathVariable int idCategoria) {
		return service.buscaIdCategoria(idCategoria);
	}
	
	@GetMapping("/{nomeCategoria}")
	public Categoria buscaNome (@PathVariable String nomeCategoria) {
		return service.buscaNome(nomeCategoria);
	}

	@PostMapping
	public Categoria adicionar (@Valid @RequestBody Categoria categoria) {
		return service.incluir(categoria);
	}
	
	@PutMapping("/{id}")
	public Categoria atualizar (@PathVariable int id, @RequestBody Categoria categoria) {
		return service.atualizar(categoria, id);
	}
		
	@DeleteMapping("/{id}")
	public void apagar(@PathVariable int id) {
		service.apagar(id);
	}
}
