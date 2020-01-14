package com.messagerouter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.messagerouter.model.Customer;

public class MessageService {
	
static final Logger log = LoggerFactory.getLogger(MessageService.class);
	
	public Customer processMessage(Customer customer){
		log.info("Methood Invoked Received:"+ customer );
		
		
		return customer;
	}

}
