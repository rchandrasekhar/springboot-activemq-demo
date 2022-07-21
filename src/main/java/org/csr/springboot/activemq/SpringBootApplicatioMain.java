package org.csr.springboot.activemq;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.csr.springboot.activemq.model.User;
import org.csr.springboot.activemq.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import java.util.Date;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableJms
public class SpringBootApplicatioMain {

	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootApplicatioMain.class, args);   
	}
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("csr.queue");
	}
	
	@Autowired
	private UserRepository userRepository;
	
	 // spring calls after the initialization of bean properties
	  @PostConstruct
	  private void initDb() {
	    User user = new User();
	    user.setUserName("PeterM");
	    user.setPassword("ABC123abc*");
	    user.setDateofBirth(new Date());
	    user.setCreationTime(new Date());
	    userRepository.save(user);
	  }
}
