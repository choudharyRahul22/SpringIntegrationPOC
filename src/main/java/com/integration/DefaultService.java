package com.integration;

import org.springframework.messaging.Message;

public class DefaultService {
	
	public void print(Message<?> message){
		System.out.println("Default : " + message.getPayload());
	}

}
