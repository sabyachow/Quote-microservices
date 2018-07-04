package com.rating.auto.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rating.auto.model.Quote;


public interface QuoteRepository extends MongoRepository<Quote, String>{

}
