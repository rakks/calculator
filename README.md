# calculator


Build the project:
mvn clean install

Run the Test cases using Junit - CalculatorControllerTest.java 

Run the Application: 
java -jar target/calculator-0.0.1-SNAPSHOT.jar


URLs: 
POST http://localhost:8080/calculator/add
POST http://localhost:8080/calculator/subtract
POST http://localhost:8080/calculator/multiply
POST http://localhost:8080/calculator/divide
GET http://localhost:8080/calculator/results
GET http://localhost:8080/calculator/results?fromDate=02022020&toDate=02022020
GET http://localhost:8080/calculator/results?date=02022020

