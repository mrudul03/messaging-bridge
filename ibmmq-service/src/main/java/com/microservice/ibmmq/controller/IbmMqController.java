package com.microservice.ibmmq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.ibmmq.service.MqService;

@RestController
@RequestMapping(value="/api/ibmmqservice")
public class IbmMqController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IbmMqController.class);
	@Autowired
	private MqService msService;
	
	@PostMapping("/messages")
	public ResponseEntity<String> postMessage(@RequestBody String message){
		
		LOGGER.info("called postMessage");
		String responseMessage = "";
		try {
			msService.sendMessage(message);
			responseMessage = "Sent message ---"+message;
		}
		catch(Exception e) {
			responseMessage = "Error Sending message....";
		}
		
		return ResponseEntity.ok(responseMessage);
	}

}
