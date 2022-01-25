package br.com.interplacecom.loja.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class InfoFornecedorDTO {
	
	private Long id;
	
	private String nome;
	
	private String estado;
	
	private String endereco;

}
