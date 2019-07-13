package com.jms.spring.endpoint;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
	private JmsTemplate jmstemplate;
	private static final String ORDER_RESPONSE_QUEUE = "myQueue";
	
	@Autowired
	public void setConnectionFactory(ConnectionFactory cf){
		this.jmstemplate = new JmsTemplate(cf);
	}
	
	public void send() {
		System.out.println("Sending message to queue");
		for(int i=0;i<100;i++){
			final int j=i;
			this.jmstemplate.send(ORDER_RESPONSE_QUEUE, new MessageCreator() {
				
				@Override
				public Message createMessage(Session session) throws JMSException {
					TextMessage message = session.createTextMessage("My text: "+j);
					System.out.println("Producer has sent the message: "+message.getText());
					return message;
				}
			});
		}
	}

}
