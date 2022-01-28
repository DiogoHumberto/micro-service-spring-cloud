package br.com.interplacecom.fornecedor.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.interplacecom.fornecedor.controller.dto.InfoFornecedorDto;
import br.com.interplacecom.fornecedor.domain.InfoFornecedor;
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
	public ResponseEntity<InfoFornecedorDto> createFornecedor(@RequestBody @Validated InfoFornecedorDto infoFornecedorDto, UriComponentsBuilder uriBuilder) throws Exception {
		infoService.salvar(infoFornecedorDto);
		URI uri = uriBuilder.path("/fornecedor/create/{fornecedor}").buildAndExpand(infoFornecedorDto.getNome()).toUri();
		return ResponseEntity.created(uri).build();	
		
//		return ResponseEntity
//      .status(HttpStatus.CREATED)
//      .body(infoService.salvar(infoFornecedorDto));
		
	}
	
	@GetMapping("/fornecedores")
	public ResponseEntity<Page<InfoFornecedor>> listaFornecedores(@RequestParam Pageable paginacao){
		return  ResponseEntity
					.status(HttpStatus.CREATED)
					.body(infoService.listaFornecedor(paginacao));
	}
}
