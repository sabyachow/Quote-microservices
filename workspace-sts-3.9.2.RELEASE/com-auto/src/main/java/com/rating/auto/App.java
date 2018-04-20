package com.rating.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rating.auto.model.Quote;
import com.rating.auto.service.QuoteService;

/**
 * Hello world!
 *
 */

@EnableCircuitBreaker

@SpringBootApplication
public class App 
{
	
	@Bean
	public RestTemplate rest(RestTemplateBuilder builder) {
	    return builder.build();
	}

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
