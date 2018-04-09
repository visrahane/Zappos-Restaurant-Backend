# Zappos-Restaurant-Backend
Zappos Restaurant System

### Q) How to use this service?

It is a Spring Boot application and the final executable is .jar file. 

Requirements:
<br>Java - 1.8
<br>Redis
<br>MySql

Steps to run the web-service:
1) Clone the master branch into your local machine.
2) Run the project as a Maven build. 
Command : mvn clean install
3) Look for the .jar file in the target folder of the project. 
4) Copy the .jar file to a particular(for deployment) folder.
5) You can have application.properties in the same folder where you placed your .jar to override default properties. Refer https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html for more details.
6) Execute the .jar file.
   Command:java -jar Zappos-Restaurant-Backend-0.0.1.jar
Note: Run the command in background to keep it running even if you log out of the computer.

Getting started with development:

Requirements:
IDE- preferred Eclipse with Spring boot plugin and maven build support or STS.

1) Clone the master branch into your local machine.
2) Import in your ide.
3) Run Application.java as java application. Wait for successfull completion.

<br>
Server: AWS
<br>API Docs: http://ec2-13-57-34-163.us-west-1.compute.amazonaws.com:8080/zappos-restaurant-backend/swagger-ui.html
