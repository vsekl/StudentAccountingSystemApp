# StudentAccountingSystem

A student accounting system application that realizes REST API and stores data in database.  
Stack: Java, Spring (BOOT, WEB, DATA), Maven, Hibernate, Liquibase, PostgreSQL, JUnit, Testcontainers, Docker, Lombok.

How to execute:
1) First of all, you need to change properties to connect with your database.  
   Properties are stored in "src/main/resources/application.properties".  
   You have to change spring.datasource.url=jdbc:postgresql://localhost:5432/'YOUR_DB_NAME'    
   spring.datasource.username='YOUR_USERNAME'  
   spring.datasource.password='YOUR_PASSWORD'  
2) PgAdmin should be opened, make sure that database exists.
3) Build project with a help of IDE or with Maven terminal commands.
4) Run program with a help of IDE or with java -jar command. 
5) If you want to send a POST request, you can use Postman.
6) If you want to run tests, so Docker should be installed on your PC.



