package com.integration;

import org.springframework.messaging.Message;

public class UpperCasePrintService {

	public void print(Message<String> message){
		System.out.println("Print service - " + message.getPayload().toUpperCase());
	}
}
