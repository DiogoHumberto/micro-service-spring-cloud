package br.com.interplacecom.loja.controller;

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

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	@PostMapping(path = "/efetuar")
	public void realizaCompra(@RequestBody CompraDTO compra) {
		
		compraService.realizarCompra(compra);
	}
	
	@GetMapping(path = "/token")
	public ResponseEntity<TokenDto> discoveryClientTest() {
		TokenDto token = compraService.buscaToken();
		return ResponseEntity.ok(token);
	}

}
