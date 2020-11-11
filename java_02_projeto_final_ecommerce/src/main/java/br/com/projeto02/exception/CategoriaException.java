package br.com.projeto02.exception;

public class CategoriaException extends RuntimeException {

	public CategoriaException(String mensagem) {
		this.mensagem = mensagem;
	}
	
	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}
}
