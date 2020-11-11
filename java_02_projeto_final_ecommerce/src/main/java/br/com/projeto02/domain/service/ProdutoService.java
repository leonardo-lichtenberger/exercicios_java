package br.com.projeto02.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto02.domain.model.Produto;
import br.com.projeto02.domain.repository.IProdutoRepository;
import br.com.projeto02.exception.ProdutoException;


@Service
public class ProdutoService {

	@Autowired
	IProdutoRepository repositorio;

	public Produto incluir(Produto produto) {
		
		Optional<Produto> produtoBanco = repositorio.findByNomeProduto(produto.getNomeProduto());
				
		if(produtoBanco.isPresent()) {
			int categoriaBanco = produtoBanco.get().getCategoria().getIdCategoria();
			int categoriaProduto = produto.getCategoria().getIdCategoria();
			
			if(categoriaBanco != categoriaProduto) {
				throw new ProdutoException("Produto já casdastrado em outra categoria");
			}					
		}
				
		if (produtoBanco.isPresent()) {	
			int quantidadeBanco = produtoBanco.get().getEstoque().getQuantidade();
			int quantidaNovo = produto.getEstoque().getQuantidade();
			
			produtoBanco.get().getEstoque().setQuantidade(quantidadeBanco + quantidaNovo);
			
			return repositorio.save(produtoBanco.get());
		
		}	
			
		return repositorio.save(produto);
	}

	public List<Produto> listaTodos() {
		return repositorio.findAll();
	}
	
	public Produto buscaId(int idProduto) {
		
		Optional<Produto> isProduto = Optional.ofNullable(repositorio.findByIdProduto(idProduto));

		if (!isProduto.isPresent())
			throw new ProdutoException("Id inválido. Este produto não existe!");
			
		return repositorio.findByIdProduto(idProduto);
	}
	
	public Produto buscaCodigo(String codigoProduto) {
		
		Optional<Produto> isProduto = Optional.ofNullable(repositorio.findByCodigoProduto(codigoProduto));

		if (!isProduto.isPresent())
			throw new ProdutoException("Código inválido. Este produto não existe!");
			
		return repositorio.findByCodigoProduto(codigoProduto);
	}
	
	public Produto atualizar(Produto produto, int id) {
		
		Optional<Produto> isProduto = repositorio.findById(id);

		if (!isProduto.isPresent())
			throw new ProdutoException("Id inválido! Esse produto não existe!");
		produto.setIdProduto(id);
		return repositorio.save(produto);
	}

	public void apagar(int id) {

		Optional<Produto> isProduto = repositorio.findById(id);

		if (!isProduto.isPresent())
			throw new ProdutoException("Id inválido! Esse produto não existe!");

		repositorio.deleteById(id);
	}
}
