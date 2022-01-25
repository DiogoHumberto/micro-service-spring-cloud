package br.com.interplacecom.loja.domain.exceptions;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;

public class ExceptionResponseDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExceptionResponseDto(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	@Getter
	private Date timestamp;
	@Getter
	private String message;
	@Getter
	private String details;
}
