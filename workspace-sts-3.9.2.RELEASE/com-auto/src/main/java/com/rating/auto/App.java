package com.rating.auto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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
