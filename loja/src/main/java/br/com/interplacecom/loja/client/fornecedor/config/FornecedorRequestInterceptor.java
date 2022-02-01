package br.com.interplacecom.loja.client.fornecedor.config;

import org.springframework.http.HttpHeaders;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FornecedorRequestInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate templateFornecedor) {
		templateFornecedor.header(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
	}

}
