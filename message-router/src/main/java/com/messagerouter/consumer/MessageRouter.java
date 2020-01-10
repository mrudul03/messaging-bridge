package com.messagerouter.consumer;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.messagerouter.service.MessageService;

@Component
public class MessageRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("jms:DEV.QUEUE.2")
		.bean(MessageService.class, "processMessage")
		.process(new Processor(){
			@Override
			public void process(Exchange exchange) throws Exception {
				String message = exchange.getIn().getBody(String.class);
				log.info("Message.....:"+message);
			}
		})
		//.marshal().json(JsonLibrary.Jackson)
		.to("activeMq:ACT.QUEUE.1")
		.log(LoggingLevel.INFO, log, "Message Sent to Active MQ.")
		.end();
	}

}
