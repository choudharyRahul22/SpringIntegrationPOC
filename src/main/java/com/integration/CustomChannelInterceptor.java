package com.integration;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptorAdapter;

public class CustomChannelInterceptor extends ChannelInterceptorAdapter {

	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		Message<?> msg = MessageBuilder.withPayload(" Intercepted " + message).build();
		return super.preSend(msg, channel);
	}
	
	

}
