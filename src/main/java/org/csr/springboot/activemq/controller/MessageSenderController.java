package org.csr.springboot.activemq.controller;

import javax.jms.Queue;

import org.csr.springboot.activemq.jms.MessageCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/execute")
public class MessageSenderController {
	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queue;

	/**this method response to GET request http://localhost/provision */
	@GetMapping("/pushmessage/{operation}")
	public @ResponseBody String post(@PathVariable String operation) {	
		// This will put text message to queue
		try {
			// This will put text message to queue
			this.jmsMessagingTemplate.convertAndSend(this.queue, operation);
			System.out.println(operation + " -> Message has been put to queue by sender");	
			return "{\"id\":\""+operation+"\",\"send\":\"success\"}";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "{\"id\":\""+operation+"\",\"send\":\"failed\"}";
	}

}
