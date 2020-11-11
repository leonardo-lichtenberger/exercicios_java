package br.com.projeto02.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto02.domain.model.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
	
	public boolean existsByNomeCategoria(String nomeCategoria);

	public Categoria findByNomeCategoria(String nomeCategoria);

	public Categoria findByIdCategoria(int idCategoria);

}
