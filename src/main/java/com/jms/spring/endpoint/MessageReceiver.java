package com.jms.spring.endpoint;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver{
	private static final String ORDER_RESPONSE_QUEUE = "myQueue";

	/*
	 * The container factory to use is identified by the containerFactory attribute 
	 * defining the name of the JmsListenerContainerFactory bean to use. 
	 * When none is set a JmsListenerContainerFactory bean with name jmsListenerContainerFactory is assumed to be present.
	 * @See @Url https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jms/annotation/EnableJms.html
	 */
	
	@JmsListener(destination=ORDER_RESPONSE_QUEUE,containerFactory="myJmsListenerContainerFactory")
	public void receive(Message msg) {
		TextMessage txt=(TextMessage) msg;
		try {
			System.out.println("Message received by consumer: "+txt.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
