package br.com.interplacecom.loja.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.interplacecom.loja.client.getnet.config.GetNetApiConfiguration;
import br.com.interplacecom.loja.controller.dto.TokenDto;

@FeignClient( name = "GetNet-api", url = "https://api-homologacao.getnet.com.br", configuration = GetNetApiConfiguration.class)
public interface GetNetApi {
	
	@RequestMapping(value = "/credenciamento/auth/oauth/v2/token", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<TokenDto> buscarToken();

}
