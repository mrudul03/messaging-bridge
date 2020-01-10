package com.messagerouter;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;

@Configuration
public class MessageRouterConfiguration {
	
	String BROKER_URL = "tcp://localhost:61616"; 
	String BROKER_USERNAME = "admin"; 
	String BROKER_PASSWORD = "admin";
	
//	@Bean
//	public JmsTransactionManager jmsTransactionManager(final ConnectionFactory connectionFactory){
//		JmsTransactionManager jmsTransactionManager = new JmsTransactionManager();
//		jmsTransactionManager.setConnectionFactory(connectionFactory);
//		return jmsTransactionManager;
//	}
//
//	@Bean
//	public JmsComponent createJmsComponent() throws Exception {
//		
//		JmsComponent jmsComponent = JmsComponent.jmsComponentTransacted(connectionFactory());
//		jmsComponent.setMaxConcurrentConsumers(2);
//		return jmsComponent;
//	}
//	
//	@Bean
//	public MQQueueConnectionFactory connectionFactory() throws Exception {
//		MQQueueConnectionFactory connFact = new MQQueueConnectionFactory();
//		connFact.setHostName("localhost");
//        connFact.setChannel("DEV.ADMIN.SVRCONN");
//        connFact.setPort(1414);
//        connFact.setQueueManager("QMGR");
//        connFact.setTransportType(1);
//        connFact.setStringProperty(WMQConstants.USERID, "admin");
//        connFact.setStringProperty(WMQConstants.PASSWORD, "passw0rd");
//        return connFact;
//	}
	
	@Bean
	public JmsComponent ibmMq() throws Exception {
		
		JmsComponent jmsComponent = JmsComponent.jmsComponentTransacted(ibmMqConnectionFactory());
		jmsComponent.setMaxConcurrentConsumers(2);
		return jmsComponent;
	}
	
	@Bean
	public MQQueueConnectionFactory ibmMqConnectionFactory() throws Exception {
		MQQueueConnectionFactory connFact = new MQQueueConnectionFactory();
		connFact.setHostName("localhost");
        connFact.setChannel("DEV.ADMIN.SVRCONN");
        connFact.setPort(1414);
        connFact.setQueueManager("QMGR");
        connFact.setTransportType(1);
        connFact.setStringProperty(WMQConstants.USERID, "admin");
        connFact.setStringProperty(WMQConstants.PASSWORD, "passw0rd");
        return connFact;
	}
	
	@Bean
	public JmsComponent activeMq() throws Exception {
		
		JmsComponent jmsComponent = JmsComponent.jmsComponentTransacted(activeMqConnectionFactory());
		jmsComponent.setMaxConcurrentConsumers(2);
		return jmsComponent;
	}
	
	@Bean
	public ActiveMQConnectionFactory activeMqConnectionFactory() throws Exception {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
	    connectionFactory.setBrokerURL(BROKER_URL);
	    connectionFactory.setPassword(BROKER_USERNAME);
	    connectionFactory.setUserName(BROKER_PASSWORD);
	    return connectionFactory;
	}
	
}
