package com.messagerouter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageService {
	
static final Logger log = LoggerFactory.getLogger(MessageService.class);
	
	public String processMessage(String message){
		log.info("Methood Invoked Received:"+ message );
		
		
		return message;
	}

}
