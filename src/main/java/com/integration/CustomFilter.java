package com.integration;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

public class CustomFilter implements MessageSelector {

	@Override
	public boolean accept(Message<?> message) {
		// TODO Auto-generated method stub
		return message.getPayload().equals(5);
	}

}
