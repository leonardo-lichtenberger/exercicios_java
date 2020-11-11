package br.com.projeto02.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.sun.istack.NotNull;

@Entity
@Table(name = "pedido_item")
public class PedidoItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPedidoItem;

	@NotNull
	private int quantidade;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;

	public int getIdPedidoItem() {
		return idPedidoItem;
	}

	public void setIdPedidoItem(int idPedidoItem) {
		this.idPedidoItem = idPedidoItem;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPedidoItem;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoItem other = (PedidoItem) obj;
		if (idPedidoItem != other.idPedidoItem)
			return false;
		return true;
	}	
}
