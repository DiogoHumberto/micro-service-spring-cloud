package br.com.interplacecom.fornecedor.domain.mapper;

import br.com.interplacecom.fornecedor.controller.dto.InfoFornecedorDto;
import br.com.interplacecom.fornecedor.domain.InfoFornecedor;

public class InfoFornecedorMapper {
	
	public static InfoFornecedorDto toVO(InfoFornecedor infoFornecedor) {
		return InfoFornecedorDto.builder()
				.id(infoFornecedor.getId())
				.nome(infoFornecedor.getNome())
				.estado(infoFornecedor.getEstado())
				.endereco(infoFornecedor.getEndereco()).build();
	}
	
	public static InfoFornecedor toEntity(InfoFornecedorDto infoFornecedorVO) {
		return InfoFornecedor.builder()
				.id(infoFornecedorVO.getId())
				.nome(infoFornecedorVO.getNome())
				.estado(infoFornecedorVO.getEstado())
				.endereco(infoFornecedorVO.getEndereco()).build();
	}

}
