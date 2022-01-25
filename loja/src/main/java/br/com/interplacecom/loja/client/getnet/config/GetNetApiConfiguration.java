package br.com.interplacecom.loja.client.getnet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
public class GetNetApiConfiguration {
	 @Bean
	    public RequestInterceptor requestInterceptor(){
	        return new GETNETRequestInterceptor();
	    }

}
