# Spring Boot + ActiveMQ example
Spring boot comes with embedded ActiveMQ similar to tomcat, so you don’t have to create external ActiveMQ.

If you want to use external activemq, just use below application.properties
	
	spring.activemq.broker-url=tcp://localhost:61616
	
Please note that you just need to provide ActiveMQ broker url, if you specify above property then Spring boot won’t create another in memory embedded ActiveMQ.

----------- Libraries perspective
	activemq-broker-5.14.5.jar
	activemq-client-5.14.5.jar
	spring-jms-4.3.8.RELEASE.jar
These libraries will provide the required activemq and jms capabilities.

----------- REST API
Request: http://localhost:8081/execute/pushmessage/HELLODEVELOPER

Response: {"id":"HELLODEVELOPER","send":"success"}

Log: 
HELLODEVELOPER -> Message has been put to queue by sender
Message Received: HELLODEVELOPER

----------- Code perspective
@SpringBootApplication is an annotation that adds all of the following:

@Configuration makes the class as a source of bean definitions for the application context.

@EnableAutoConfiguration enables Spring boot to add beans presents in classpath setting and various property setting. This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.

@ComponentScan tells Spring to look for other components, configurations, and services in the default package, allowing it to find the controllers. If specific packages are not defined, scanning will occur from the package of the class that declares this annotation.

@EnableJMS annotation is used to trigger search for method annotated with @JMSListener, hence to create JMS listener in the background.

