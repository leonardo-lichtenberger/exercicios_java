package br.com.projeto02.exception;

public class UsuarioException extends RuntimeException {
	
	public UsuarioException(String mensagem) {
		this.mensagem = mensagem;
	}
	
	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}
}
