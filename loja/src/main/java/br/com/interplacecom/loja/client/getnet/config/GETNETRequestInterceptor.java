package br.com.interplacecom.loja.client.getnet.config;

import org.springframework.http.HttpHeaders;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class GETNETRequestInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate template) {
		template.header(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
		template.body("");
		template.header(HttpHeaders.AUTHORIZATION, "Basic ZjI0NGRhODgtMTkzNi00NDNjLTg2MjQtNjI3MTA3NGM0ZmRiOmM2M2E2MjcxLTVmYjgtNGJkMi1hYWE4LWRlYTI3OTQ4YjNmZQ==");
		//template.header("Content-type", "application/x-www-form-urlencoded");
		template.query("scope", "mgm");
		template.query("grant_type", "client_credentials");
		
	}

}
