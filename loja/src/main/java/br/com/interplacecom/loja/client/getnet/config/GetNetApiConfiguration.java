package br.com.interplacecom.loja.client.getnet.config;

import org.springframework.context.annotation.Bean;


public class GetNetApiConfiguration {
	@Bean
	public GETNETRequestInterceptor requestInterceptorApiGetNet() {
		return new GETNETRequestInterceptor();
	}

}
