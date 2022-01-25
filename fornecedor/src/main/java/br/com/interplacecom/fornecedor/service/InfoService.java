package br.com.interplacecom.fornecedor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.interplacecom.fornecedor.controller.dto.InfoFornecedorDto;
import br.com.interplacecom.fornecedor.domain.InfoFornecedor;
import br.com.interplacecom.fornecedor.domain.exceptions.FornecedorErrorServer;
import br.com.interplacecom.fornecedor.domain.mapper.InfoFornecedorMapper;
import br.com.interplacecom.fornecedor.repository.InfoRepository;

@Service
public class InfoService {
	
	private static final Logger LOG = LoggerFactory.getLogger(InfoService.class);
	
	@Autowired
	private InfoRepository infoRepository;
	
	public InfoFornecedorDto getInfoPorEstado(String estado) {	
		LOG.info("Buscando fornecedor de {} ", estado);
		InfoFornecedor infoFornecedor =  infoRepository.findByEstado(estado);	 
		return infoFornecedor != null ? InfoFornecedorMapper.toVO(infoFornecedor) : null;
	}
	
	public boolean saveInfoFornecedorConverter(InfoFornecedorDto infoFornecedorDto) {
		InfoFornecedor infoFornecedor = InfoFornecedorMapper.toEntity(infoFornecedorDto);
		try {
			LOG.info("Salvando dados fornecedor: {} ", infoFornecedorDto.toString());
			boolean salvo = infoRepository.save(infoFornecedor) != null;
			return salvo;
		} catch (Exception e) {
			e.getStackTrace();
			e.getLocalizedMessage();
			throw new FornecedorErrorServer("Erro ao salvar fornecedor :" + infoFornecedor.toString());
		}			
		
	}
}
