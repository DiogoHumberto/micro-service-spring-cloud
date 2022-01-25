package br.com.interplacecom.loja.controller.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompraDTO {
	
	private List<ItemCompraDTO> itens;
	
	private EnderecoDTO endereco;

}
