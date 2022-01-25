package br.com.interplacecom.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.interplacecom.loja.client.FornecedorClient;
import br.com.interplacecom.loja.client.GetNetApi;
import br.com.interplacecom.loja.controller.dto.CompraDTO;
import br.com.interplacecom.loja.controller.dto.InfoFornecedorDTO;
import br.com.interplacecom.loja.controller.dto.TokenDto;
import br.com.interplacecom.loja.domain.exceptions.CompraNotFound;

@Service
public class CompraService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	
	@Autowired
	private FornecedorClient fornecedorClient;
	@Autowired
	private GetNetApi getNetApi;	
	
	public void realizarCompra(CompraDTO compra) {
		LOG.info("Iniciando compra {} ", compra.toString());
		LOG.info("Buscando fornecedor {} ", compra.getEndereco().getEstado());
		InfoFornecedorDTO fornecedorEstado = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		if (fornecedorEstado == null) {
			LOG.info("fornecedor {} não encontrado ", compra.getEndereco().getEstado());
			throw new CompraNotFound("Fornecedor não encontrado :  " +  compra.getEndereco() );
		}		
	}
	
	public TokenDto buscaToken() {
		return getNetApi.buscarToken().getBody();
	}

}
