package com.rating.auto.service;

import java.net.URI;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rating.auto.controller.GreetingController;
import com.rating.auto.model.Customer;
import com.rating.auto.model.Quote;
import com.rating.auto.model.Vehicle;

@Service
public class QuoteService {
    private static final Logger log = LoggerFactory.getLogger(QuoteService.class);
    private static final AtomicLong q_counter = new AtomicLong();
    private final RestTemplate restTemplate;
    
    public QuoteService(RestTemplate rest) {
        this.restTemplate = rest;
    }
    
	@HystrixCommand(fallbackMethod = "reliable")
	public Quote getQuote(List<Customer> customers, List<Vehicle> vehicles) {
		URI uri = URI.create("http://localhost:8090/customers/eligibility/"+customers.get(0).getId());
		String eligibility = restTemplate.getForObject(uri, String.class);
		
	    
		long premium = 0;
		if(("Y").equals(eligibility))
			premium = getPremium();
	    log.info("Premium:"+premium);

		return new Quote(q_counter.incrementAndGet(), customers, vehicles, premium);
	}
 	
	 public Quote reliable(List<Customer> customers, List<Vehicle> vehicles) {

			return new Quote(q_counter.incrementAndGet(), customers, vehicles, 0);
	}
	
	private long getPremium() {
		return new Random().nextLong();	
	}

}
