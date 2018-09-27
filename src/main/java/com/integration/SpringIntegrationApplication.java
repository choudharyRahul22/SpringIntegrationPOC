package com.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
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
	
	@Autowired
	private DirectChannel outputChannel;

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {

		/*
		 * Subscription should be done before sending
		 */
		outputChannel.subscribe(new MessageHandler() {
			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				System.out.println(message);
			}
		});

		Message<String> message = MessageBuilder.withPayload("Using builder design pattern").setHeader("key", "value")
				.setHeader("key2", "value2").build();

		inputChannel.send(message);

	}
}
