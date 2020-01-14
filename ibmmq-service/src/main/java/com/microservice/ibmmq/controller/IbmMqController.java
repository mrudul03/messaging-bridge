package com.microservice.ibmmq.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.ibmmq.service.Customer;
import com.microservice.ibmmq.service.MqService;

@RestController
@RequestMapping(value="/api/ibmmqservice")
public class IbmMqController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IbmMqController.class);
	@Autowired
	private MqService msService;
	
	@PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE,
			 value="/customers")
	public ResponseEntity<Customer> postMessage(@RequestBody Customer customer){
		
		LOGGER.info("called postMessage");
		try {
			msService.sendMessage(customer);
		}
		catch(Exception e) {
			LOGGER.error("", e);
		}
		return ResponseEntity.ok(customer);
	}

}
