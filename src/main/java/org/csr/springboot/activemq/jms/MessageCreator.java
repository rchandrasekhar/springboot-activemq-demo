package org.csr.springboot.activemq.jms;
import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
//public class MessageCreator implements CommandLineRunner {
public class MessageCreator {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queue;

	//This method is to run in standalone mode using CommandLineRunner
	/*public void run(String... arg0) throws Exception {
		// This will put text message to queue
		this.jmsMessagingTemplate.convertAndSend(this.queue, "Hello from Developer!!");
		System.out.println("Message has been put to queue by sender");
	}*/
	
	public String sendMsg(String txt) throws Exception {
		// This will put text message to queue
		this.jmsMessagingTemplate.convertAndSend(this.queue, txt);
		System.out.println(txt + " -> Message has been put to queue by sender");	
		return "{\"id\":\""+txt+"\",\"send\":\"success\"}";
	}
}