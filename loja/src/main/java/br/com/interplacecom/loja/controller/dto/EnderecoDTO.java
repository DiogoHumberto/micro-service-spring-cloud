package br.com.interplacecom.loja.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EnderecoDTO {
	
	private String rua;
	
	private int numero;
	
	private String estado;

}
