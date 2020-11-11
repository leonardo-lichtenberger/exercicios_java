package br.com.projeto02.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto02.domain.model.Categoria;
import br.com.projeto02.domain.repository.ICategoriaRepository;
import br.com.projeto02.exception.CategoriaException;

@Service
public class CategoriaService {

	@Autowired
	ICategoriaRepository repositorio;

	public Categoria incluir(Categoria c) {
		if(repositorio.existsByNomeCategoria(c.getNomeCategoria())){
			throw new CategoriaException("Categoria já cadastrada!");
		}
		return repositorio.save(c);
	}

	public List<Categoria> listaTodos() {
		return repositorio.findAll();
	}
	
	public Categoria buscaIdCategoria(int idCategoria) {
		
		Optional<Categoria> isCategoria = Optional.ofNullable(repositorio.findByIdCategoria(idCategoria));

		if (!isCategoria.isPresent())
			throw new CategoriaException("Id inválido. Esta Categoria não existe!");
			
		return repositorio.findByIdCategoria(idCategoria);
	}

	public Categoria buscaNome(String nomeCategoria) {
		
		Optional<Categoria> isCategoria = Optional.ofNullable(repositorio.findByNomeCategoria(nomeCategoria));

		if (!isCategoria.isPresent())
			throw new CategoriaException("Nome inválido. Esta Categoria não existe!");
			
		return repositorio.findByNomeCategoria(nomeCategoria);
	}
	
	public Categoria atualizar(Categoria c, int id) {
		
		Optional<Categoria> isCategoria = repositorio.findById(id);

		if (!isCategoria.isPresent())
			throw new CategoriaException("Id inválido! Essa categoria não existe!");
		c.setIdCategoria(id);
		return repositorio.save(c);
	}

	public void apagar(int id) {

		Optional<Categoria> isCategoria = repositorio.findById(id);

		if (!isCategoria.isPresent())
			throw new CategoriaException("Id inválido! Essa categoria não existe!");

		repositorio.deleteById(id);
	}	
}
