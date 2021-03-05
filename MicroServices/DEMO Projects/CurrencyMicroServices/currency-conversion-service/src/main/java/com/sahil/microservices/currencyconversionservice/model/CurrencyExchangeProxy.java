package com.sahil.microservices.currencyconversionservice.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*	
 * Proxy of CurrencyExcahnge MicroService to call it from CurrencyConversion
 * name is to be application name of CurrencyExcahnge MicroService
 * url is port number of running MicroService will be removing it later to get it automatically
 * from service registry also called as naming server..
*/
@FeignClient(name="currency-exchange",url="localhost:8000")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(
			@PathVariable String from,
			@PathVariable String to);
	
}
