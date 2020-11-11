package br.com.projeto02.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.projeto02.exception.CategoriaException;
import br.com.projeto02.exception.PedidoException;
import br.com.projeto02.exception.ProdutoException;
import br.com.projeto02.exception.UsuarioException;

@RestControllerAdvice
public class ExceptionController {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errosOcorridos = new HashMap<>();
		List<ObjectError> erros = ex.getBindingResult().getAllErrors();

		for (ObjectError erro : erros) {
			String atributo = ((FieldError) erro).getField();
			String mensagem = erro.getDefaultMessage();
			errosOcorridos.put(atributo, mensagem);
		}
		return errosOcorridos;
	}
	
	@ExceptionHandler(CategoriaException.class)
	public ResponseEntity<String> trataCategoriaException(CategoriaException e) {
		
		return ResponseEntity
				.notFound()
				.header("error_code", "INVALID_REQUEST")
				.header("error_value", e.getMensagem())
				.build();
	}
	
	@ExceptionHandler(UsuarioException.class)
	public ResponseEntity<String> trataUsuarioException(UsuarioException e) {
		
		return ResponseEntity
				.notFound()
				.header("error_code", "INVALID_REQUEST")
				.header("error_value", e.getMensagem())
				.build();
	}
	
	@ExceptionHandler(ProdutoException.class)
	public ResponseEntity<String> trataProdutoException(ProdutoException e) {
		
		return ResponseEntity
				.notFound()
				.header("error_code", "INVALID_REQUEST")
				.header("error_value", e.getMensagem())
				.build();
	}
	
	@ExceptionHandler(PedidoException.class)
	public ResponseEntity<String> trataPedidoException(PedidoException e) {
		
		return ResponseEntity
				.notFound()
				.header("error_code", "INVALID_REQUEST")
				.header("error_value", e.getMensagem())
				.build();
	}

}
