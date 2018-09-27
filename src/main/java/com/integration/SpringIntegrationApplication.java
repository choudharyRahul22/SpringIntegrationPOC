package com.integration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationApplication implements ApplicationRunner {

	@Autowired
	private PrintGateway gateway;

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		List<Future<Message<String>>> futures = new ArrayList<Future<Message<String>>>();
		for (int x = 0; x < 10 ; x++) {
			/*
			 * Higher Priority Message will be processes first in PriorityChannel
			 * 
			 * We can define priority either on message using setPriority method or 
			 * we can create a custom class and refer in <int:priority-queue capacity="10" comparator="customComparator"/>
			 */
			
			/*
			 * Message<String> message = MessageBuilder.withPayload("Printing message for - " + x).setHeader("messageNumber", x).setPriority(x).build();
			*/
			
			
			Message<String> message = MessageBuilder.withPayload("Printing message for - " + x).setHeader("messageNumber", x).setPriority(x).build();
			
			System.out.println("Sending message - " + x);
			futures.add(this.gateway.print(message));
		}
		
		for (Future<Message<String>> future : futures) {
			System.out.println(future.get().getPayload());
		}
	}
}
