# Spring Boot + ActiveMQ example
Spring boot comes with embedded ActiveMQ similar to tomcat, so you don’t have to create external ActiveMQ.

If you want to use external activemq, just use below application.properties
	- spring.activemq.broker-url=tcp://localhost:61616
	
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

----- H2  In memory database
What is H2 Database?
H2 is a open-source relational database management system written in Java. It can be embedded in Java applications or run in client-server mode. It is one of the popular In memory database. Spring Boot provides excellent integration support for H2.

H2 Database Main Features :
-Very fast and light weight database engine
-Open source
-Written in Java
-It is possible to create both in-memory tables, as well as disk-based tables.
-Supports standard SQL, JDBC API
-Embedded and Server mode, Clustering support
-Strong security features
-The PostgreSQL ODBC driver can be used
-Multi version concurrency

H2 console using web browser: 

	http://localhost:8081/h2-console/
	
	select * from user_details;

Hit the following url in browser:

	http://127.0.0.1:8081/api/users  

you will see following results in browser:
	
	[{"id":1,"userName":"PeterM","password":"ABC123abc*","creationTime":1658405982290,"updatedTime":null,"dateofBirth":"2022-07-21","dateOfBirthString":"2022-07-21"}]
