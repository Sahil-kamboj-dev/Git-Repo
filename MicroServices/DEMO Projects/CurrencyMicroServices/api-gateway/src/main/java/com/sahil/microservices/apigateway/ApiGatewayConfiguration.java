package com.sahil.microservices.apigateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
		return builder.routes()
				.route(p->p.path("/get")
					 .filters(f->f
							 	.addRequestHeader("MyHeader", "MyURI")
							 	.addRequestParameter("Param", "MyValue"))
				     .uri("http://httpbin.org:80"))
				.route(p->p.path("/currency-exchange/**")
						.uri("lb://currency-exchange")//redirect using naming server lb://-->LoadBalance and name of service on eureka server. 
						)
				.route(p->p.path("/currency-conversion-feign/**")
						.uri("lb://currency-conversion")//redirect using naming server lb://-->LoadBalance and name of service on eureka server. 
						)
				.route(p->p.path("/currency-conversion/**")
						.uri("lb://currency-conversion")//redirect using naming server lb://-->LoadBalance and name of service on eureka server. 
						)
				.route(p->p.path("/currency-conversion-new/**")//added new path and redirect it to existing one
						.filters( f -> f.rewritePath(//added filters to rewrite path
								"/currency-conversion-new/(?<segment>.*)",
								"/currency-conversion-feign/${segment}"))
						.uri("lb://currency-conversion")//redirect using naming server lb://-->LoadBalance and name of service on eureka server. 
						)
				.build();
	}

}
