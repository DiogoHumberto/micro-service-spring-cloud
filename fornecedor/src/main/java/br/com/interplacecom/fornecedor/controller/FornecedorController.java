package br.com.interplacecom.fornecedor.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.interplacecom.fornecedor.controller.dto.InfoFornecedorDto;
import br.com.interplacecom.fornecedor.service.InfoService;

@RestController
@RequestMapping("/info")
public class FornecedorController {
	
	@Autowired
	private InfoService infoService;
	
	@GetMapping("/{estado}")
	public ResponseEntity<InfoFornecedorDto> getInfoPorEstado(@PathVariable String estado) {
		InfoFornecedorDto infoFornecedorDto = infoService.getInfoPorEstado(estado);
//		if (infoFornecedorDto == null) {
//			throw new FornecedorNotFound("Não encontrado estado: " + estado);
//		}
		return ResponseEntity.ok().body(infoFornecedorDto);		
	}
	
	@PostMapping("/fornecedor/create")
	public ResponseEntity<InfoFornecedorDto> createFornecedor(@RequestBody @Validated InfoFornecedorDto infoFornecedorDto, UriComponentsBuilder uriBuilder) {
		infoService.saveInfoFornecedorConverter(infoFornecedorDto);
		URI uri = uriBuilder.path("/fornecedor/create/{fornecedor}").buildAndExpand(infoFornecedorDto.getNome()).toUri();
		return ResponseEntity.created(uri).build();			
		
	}
}
