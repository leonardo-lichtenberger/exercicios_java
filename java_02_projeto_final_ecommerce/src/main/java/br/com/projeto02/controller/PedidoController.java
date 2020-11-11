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

import br.com.projeto02.domain.model.Pedido;
import br.com.projeto02.domain.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	PedidoService service;

	@GetMapping
	public List<Pedido> listarPedidos() {
		return service.listaTodos();
	}
	
	@GetMapping("/{idPedido}")
	public Pedido buscaIdPedido (@PathVariable int idPedido) {
		return service.buscaIdPedido(idPedido);
	}
	
	@GetMapping("/codigo/{codigoPedido}")
	public Pedido buscaCodigo (@PathVariable String codigoPedido) {
		return service.buscaCodigo(codigoPedido);
	}

	@PostMapping
	public Pedido adicionar (@Valid @RequestBody Pedido pedido) {
		return service.incluir(pedido);
	}
	
	@PutMapping("/{id}")
	public Pedido atualizar (@PathVariable int id, @RequestBody Pedido pedido) {
		return service.atualizar(pedido, id);
	}
		
	@DeleteMapping("/{id}")
	public void apagar(@PathVariable int id) {
		service.apagar(id);
	}
}
