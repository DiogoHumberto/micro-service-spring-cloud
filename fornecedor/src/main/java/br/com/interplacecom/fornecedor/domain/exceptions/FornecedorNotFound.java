package br.com.interplacecom.fornecedor.domain.exceptions;

import java.text.MessageFormat;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FornecedorNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FornecedorNotFound(String field, String value) {
		super(MessageFormat.format("O seller do campo {0} com valor {1} já existe",
                field, value));
	}
	
	public FornecedorNotFound(String message, Throwable cause) {
		super(message, cause, false, true);
	}
	
	

}
