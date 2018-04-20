package com.rating.auto.controller;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rating.auto.model.Customer;
import com.rating.auto.model.Greeting;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    
        RestTemplate restTemplate = new RestTemplate();
        Customer customer = restTemplate.getForObject("http://localhost:8090/customers/2", Customer.class);
        log.info(customer.toString());
        
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}