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

import br.com.projeto02.domain.model.Usuario;
import br.com.projeto02.domain.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService service;

	@GetMapping
	public List<Usuario> listarUsuarios() {
		return service.listaTodos();
	}
	
	@GetMapping("/{idUsuario}")
	public Usuario buscaIdUsuario (@PathVariable int idUsuario) {
		return service.buscaIdUsuario(idUsuario);
	}
	
	@GetMapping("/cpf/{cpfUsuario}")
	public Usuario buscaCpf (@PathVariable String cpfUsuario) {
		return service.buscaCpf(cpfUsuario);
	}

	@PostMapping
	public Usuario adicionar (@Valid @RequestBody Usuario usuario) {
		return service.incluir(usuario);
	}
	
	@PutMapping("/{id}")
	public Usuario atualizar (@PathVariable int id, @RequestBody Usuario usuario) {
		return service.atualizar(usuario, id);
	}
		
	@DeleteMapping("/{id}")
	public void apagar(@PathVariable int id) {
		service.apagar(id);
	}
}
