package br.com.interplacecom.loja.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.interplacecom.loja.controller.dto.CompraDTO;
import br.com.interplacecom.loja.controller.dto.TokenDto;
import br.com.interplacecom.loja.service.CompraService;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	private static final Logger LOG = LoggerFactory.getLogger(CompraController.class);
	
	@Retry(name = "default")// framework - resilience4j - default 3 tentativas 
	@PostMapping(path = "/efetuar")
	public void realizaCompra(@RequestBody CompraDTO compra) {
		LOG.info("Realizando compra dos itens {}", compra.getItens().toString());
		compraService.realizarCompra(compra);
	}
	
	@GetMapping(path = "/token")
	public ResponseEntity<TokenDto> discoveryClientTest() {
		TokenDto token = compraService.buscaToken();
		return ResponseEntity.ok(token);
	}

}
