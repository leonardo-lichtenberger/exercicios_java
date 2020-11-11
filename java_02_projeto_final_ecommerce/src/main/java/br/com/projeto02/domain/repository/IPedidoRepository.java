package br.com.projeto02.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto02.domain.model.Pedido;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Integer>{
	
	public boolean existsByCodigoPedido(String codigoPedido);

	public Pedido findByCodigoPedido(String codigoPedido);

	public Pedido findByIdPedido(int idPedido);

}
