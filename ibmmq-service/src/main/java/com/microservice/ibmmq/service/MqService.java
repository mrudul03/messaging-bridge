package com.microservice.ibmmq.service;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;

@Service
public class MqService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MqService.class);

	public void sendMessage(Customer customer) throws Exception {
		
		MQQueueConnectionFactory connFact = this.createConnectionFactory();
		
		Connection conn = connFact.createConnection();
        conn.start();
        
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer messageProducer = session.createProducer(session.createQueue("DEV.QUEUE.2"));
        
        messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        messageProducer.setTimeToLive(20*1000);
        
        ObjectMapper objectMapper = new ObjectMapper();
        String messageText = objectMapper.writeValueAsString(customer);
        
        messageProducer.send(session.createTextMessage(messageText));
        LOGGER.info("Message sent to IBM MQ Queue");
	}
	
	private MQQueueConnectionFactory createConnectionFactory() throws Exception {
		// channel = DEV.ADMIN.SVRCONN
		MQQueueConnectionFactory connFact = new MQQueueConnectionFactory();
		connFact.setHostName("qmgr");
        connFact.setChannel("DEV.ADMIN.SVRCONN");
        connFact.setPort(1414);
        connFact.setQueueManager("QM1");
        connFact.setTransportType(1);
        connFact.setStringProperty(WMQConstants.USERID, "admin");
        connFact.setStringProperty(WMQConstants.PASSWORD, "passw0rd");
        return connFact;
	}
	
}
