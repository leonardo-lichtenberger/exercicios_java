package br.com.projeto02.exception;

public class ProdutoException extends RuntimeException{

	public ProdutoException(String mensagem) {
		this.mensagem = mensagem;
	}
	
	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}
}
