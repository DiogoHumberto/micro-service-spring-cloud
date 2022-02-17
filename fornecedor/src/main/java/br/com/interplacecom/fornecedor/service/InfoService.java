package br.com.interplacecom.fornecedor.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.interplacecom.fornecedor.controller.dto.InfoFornecedorDto;
import br.com.interplacecom.fornecedor.domain.InfoFornecedor;
import br.com.interplacecom.fornecedor.domain.enumerators.Booleano;
import br.com.interplacecom.fornecedor.domain.exceptions.FornecedorErrorServer;
import br.com.interplacecom.fornecedor.domain.exceptions.FornecedorNotFound;
import br.com.interplacecom.fornecedor.domain.mapper.InfoFornecedorMapper;
import br.com.interplacecom.fornecedor.repository.InfoRepository;
import lombok.NonNull;

@Service
public class InfoService {
	
	private static final Logger LOG = LoggerFactory.getLogger(InfoService.class);
	
	@Autowired
	private InfoRepository infoRepository;
	
	@Autowired
	private Environment environment;
	
	public InfoFornecedorDto getInfoPorEstado(String estado) {	
		LOG.info("Buscando fornecedor estado de {} acessando a porta {}", estado, environment.getProperty("local.server.port"));
		InfoFornecedor infoFornecedor =  infoRepository.findByEstado(estado.toUpperCase());	
		return infoFornecedor != null ? InfoFornecedorMapper.toVO(infoFornecedor) : null;
	}
	
	public boolean salvar(InfoFornecedorDto infoFornecedorDto) throws Exception {
		return Optional.of(infoFornecedorDto)
				.map(InfoFornecedorMapper::toEntity)
				.map(this::validar)
				.map(infoRepository::save)
				.orElseThrow(() -> 
				new FornecedorErrorServer("Ocorreu um erro durante o cadastro do Fornecedor: " 
				+ infoFornecedorDto.getNome())) != null;
			
	}
	
	public Page<InfoFornecedor> listaFornecedor(Pageable paginacao){
		return infoRepository.findAll(paginacao);
	}
	
	private InfoFornecedor validar(@NonNull InfoFornecedor fornecedor) {
		validarFornecedorJaExistePorCnpj(fornecedor);
		return fornecedor;
	}
	
	private void validarFornecedorJaExistePorCnpj(@NonNull InfoFornecedor fornecedor){
		if (infoRepository.findByCnpjAndStatus(fornecedor.getCnpj(), Booleano.SIM).isPresent()) {
			throw new FornecedorNotFound("CNPJ", fornecedor.getCnpj());
		}
	}
}
