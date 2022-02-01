package br.com.interplacecom.loja.client.getnet.config;

import org.springframework.http.HttpHeaders;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class GETNETRequestInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate templateGetNet) {
		templateGetNet.header(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
		templateGetNet.body("");
		templateGetNet.header(HttpHeaders.AUTHORIZATION, "Basic ZjI0NGRhODgtMTkzNi00NDNjLTg2MjQtNjI3MTA3NGM0ZmRiOmM2M2E2MjcxLTVmYjgtNGJkMi1hYWE4LWRlYTI3OTQ4YjNmZQ==");
		//template.header("Content-type", "application/x-www-form-urlencoded");
		
		
	}

}
