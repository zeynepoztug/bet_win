# bet_win

Single repository for Bet_Win game

# Tech stack
Java 11
Spring Boot 2

# Running the application
* Navigate to BetApplication.java
* Run ```mvn spring-boot:run```
* You can test the application via CURL or by running ```ServiceThreadSafetyTest.java```

# Scope
* Player is sending a bet and whole number from 1 to 100 to a server
* Server generates random whole number from 1 to 100 and if players number is greater, calculates win and sends it back to client.
* Win depends on chance - = bet * (99 / (100 - number)), as an example if player selected number 50 and bet 40.5, win would be 80,19

# Swagger UI
* To see the API documentation nativagate to ```http://localhost:8080/swagger-ui/index.html```
