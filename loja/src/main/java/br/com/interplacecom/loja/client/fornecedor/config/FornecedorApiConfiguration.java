package br.com.interplacecom.loja.client.fornecedor.config;

import org.springframework.context.annotation.Bean;

public class FornecedorApiConfiguration {
	@Bean
	public FornecedorRequestInterceptor requestInterceptorApiFornecedor() {
		return new FornecedorRequestInterceptor();
	}

}
