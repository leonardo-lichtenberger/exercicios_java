package br.com.projeto02.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto02.domain.model.Usuario;
import br.com.projeto02.domain.repository.IUsuarioRepository;
import br.com.projeto02.exception.UsuarioException;

@Service
public class UsuarioService {

	@Autowired
	IUsuarioRepository repositorio;

	public Usuario incluir(Usuario usu) {
		if(repositorio.existsByCpfUsuario(usu.getCpfUsuario())){
			throw new UsuarioException("Usuário já cadastrado!");
		}
		return repositorio.save(usu);
	}

	public List<Usuario> listaTodos() {
		return repositorio.findAll();
	}
	
	public Usuario buscaIdUsuario(int idUsuario) {
		
		Optional<Usuario> isUsuario = Optional.ofNullable(repositorio.findByIdUsuario(idUsuario));

		if (!isUsuario.isPresent())
			throw new UsuarioException("Id inválido. Este usuário não existe!");
			
		return repositorio.findByIdUsuario(idUsuario);
	}
	
	public Usuario buscaCpf(String cpfUsuario) {
		
		Optional<Usuario> isUsuario = Optional.ofNullable(repositorio.findByCpfUsuario(cpfUsuario));

		if (!isUsuario.isPresent())
			throw new UsuarioException("CPF inválido. Este usuário não existe!");
			
		return repositorio.findByCpfUsuario(cpfUsuario);
	}
	
	public Usuario atualizar(Usuario usu, int id) {
		
		Optional<Usuario> isUsuario = repositorio.findById(id);

		if (!isUsuario.isPresent())
			throw new UsuarioException("Id inválido! Esse usuário não existe!");
		usu.setIdUsuario(id);
		return repositorio.save(usu);
	}

	public void apagar(int id) {

		Optional<Usuario> isUsuario = repositorio.findById(id);

		if (!isUsuario.isPresent())
			throw new UsuarioException("Id inválido! Esse usuário não existe!");

		repositorio.deleteById(id);
	}	
}
