package com.integration;

import org.springframework.messaging.Message;

public class PrintService {

	public void print(Message<String> message){
		/*
		 * If we throw exception than the messaging framework is smart enough 
		 * it will route the message using load balancer again to other service.
		 * 
		 */
		throw new RuntimeException("Custom error");
		
		/*System.out.println("Print service - " + message.getPayload());*/
	}
}
