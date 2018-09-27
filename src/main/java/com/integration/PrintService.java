package com.integration;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

public class PrintService {

	public Message<String> print(Message<String> message){
		System.out.println("Print service - " + message.getPayload() + " - " + message.getHeaders());
		return MessageBuilder.withPayload("Reply from print service").build();
	}
}
