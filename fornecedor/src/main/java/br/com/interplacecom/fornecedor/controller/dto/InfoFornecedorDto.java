package br.com.interplacecom.fornecedor.controller.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class InfoFornecedorDto {
	
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String estado;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String cnpj;
	
}
