package com.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationApplication implements ApplicationRunner {

	/*
	 * Direct Channel is a simple type of channel that connect 2 end point and
	 * they are directly connected.
	 * 
	 * Bean defined in xml inputChannel is injected here
	 * 
	 */
	@Autowired
	private DirectChannel inputChannel;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {

		Message<String> message = MessageBuilder.withPayload("Using builder design pattern").setHeader("key", "value")
				.setHeader("key2", "value2").build();

		/*
		 * Messaging Template is used when we need to send the message within our application.
		 * We don't need to create a new channel for reply that we get from print service.
		 * 
		 * we use sendAndRecive method to send as well as recive the message.
		 * 
		 * we if see the console we find that messaging template has temporary reply and error channel
		 * using which it get back the reply.	
		 */
		Message returnMessage = new MessagingTemplate().sendAndReceive(inputChannel,message);
		System.out.println(returnMessage);

	}
}
