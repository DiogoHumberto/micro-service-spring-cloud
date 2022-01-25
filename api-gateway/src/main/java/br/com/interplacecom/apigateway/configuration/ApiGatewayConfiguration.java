package br.com.interplacecom.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
//				.route(p -> p.path("/get")
//					.filters(f -> f.addRequestHeader("teste", "teste"))
//					.uri("http://httpbin.org:80"))
				.route(p -> p.path("/loja/**")
						.uri("lb://loja"))
				.route(p -> p.path("/fornecedor/**")
						.uri("lb://fornecedor"))
				.build();
	}

}
