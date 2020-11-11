package br.com.projeto02.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto02.domain.model.Pedido;
import br.com.projeto02.domain.repository.IPedidoRepository;
import br.com.projeto02.exception.PedidoException;
import br.com.projeto02.exception.ProdutoException;

@Service
@Transactional
public class PedidoService {

	@Autowired
	IPedidoRepository repositorio;

	public Pedido incluir(Pedido pedido) {
		if(repositorio.existsByCodigoPedido(pedido.getCodigoPedido())){
			throw new PedidoException("Pedido já cadastrado!");
		}
		return repositorio.save(pedido);
	}

	public List<Pedido> listaTodos() {
		return repositorio.findAll();
	}
	
	public Pedido buscaIdPedido(int idPedido) {
		
		Optional<Pedido> isPedido = Optional.ofNullable(repositorio.findByIdPedido(idPedido));

		if (!isPedido.isPresent())
			throw new PedidoException("Id inválido. Este pedido não existe!");
			
		return repositorio.findByIdPedido(idPedido);
	}
	
	public Pedido buscaCodigo(String codigoPedido) {
		
		Optional<Pedido> isPedido = Optional.ofNullable(repositorio.findByCodigoPedido(codigoPedido));

		if (!isPedido.isPresent())
			throw new PedidoException("Código inválido. Este pedido não existe!");
			
		return repositorio.findByCodigoPedido(codigoPedido);
	}
	
	public Pedido atualizar(Pedido pedido, int id) {
		
		Optional<Pedido> isPedido = repositorio.findById(id);

		if (!isPedido.isPresent())
			throw new PedidoException("Id inválido! Esse pedido não existe!");
		pedido.setIdPedido(id);
		return repositorio.save(pedido);
	}

	public void apagar(int id) {

		Optional<Pedido> isCategoria = repositorio.findById(id);

		if (!isCategoria.isPresent())
			throw new ProdutoException("Id inválido! Esse produto não existe!");

		repositorio.deleteById(id);
	}
}
