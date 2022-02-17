package br.com.interplacecom.loja.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.interplacecom.loja.client.fornecedor.config.FornecedorApiConfiguration;
import br.com.interplacecom.loja.controller.dto.InfoFornecedorDTO;

@FeignClient(contextId = "fornecedorContexId", name = "fornecedor", configuration = FornecedorApiConfiguration.class)
public interface FornecedorClient {
	
	@RequestMapping("fornecedor/info/{estado}")
	InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

}
