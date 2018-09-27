package com.integration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationApplication.class, args);
	}
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		
		/*Map<String,Object> map = new HashMap<>();
		map.put("Key", "Value");
		MessageHeaders headers = new MessageHeaders(map);
		
		Message<String> message = new GenericMessage<String>("This is playload", headers);*/
		
		
		/* Using Builder Pattern */
		Message<String> message = MessageBuilder.withPayload("Using builder design pattern")
												.setHeader("key", "value")
												.setHeader("key2", "value2")
												.build();
		
		PrintService service = new PrintService();
		service.print(message);
	}
}
