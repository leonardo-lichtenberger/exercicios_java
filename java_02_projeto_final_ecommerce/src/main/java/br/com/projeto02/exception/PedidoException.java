package br.com.projeto02.exception;

public class PedidoException extends RuntimeException{

	public PedidoException(String mensagem) {
		this.mensagem = mensagem;
	}
	
	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}
}
