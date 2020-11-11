package br.com.projeto02.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto02.domain.model.Produto;

@Repository
public interface IProdutoRepository extends JpaRepository<Produto, Integer> {
	
	public boolean existsByCodigoProduto(String codigoProduto);

	public Produto findByCodigoProduto(String codigoProduto);

	public Produto findByIdProduto(int idProduto);

	public Optional<Produto> findByNomeProduto(String nomeProduto);

}
