package com.sahil.microservices.currencyexchangeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.microservices.currencyexchangeservice.models.CurrencyExchange;

public interface CurrencyExchangeRepository 
		extends JpaRepository<CurrencyExchange, Long>{
	
	 CurrencyExchange findByFromAndTo(String from, String to);
}
