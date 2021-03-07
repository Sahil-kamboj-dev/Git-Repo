This is Currency Exchange MicroService.

Purpose of this service to fetch currency excahnge rate from db.
I am using in memeory H2 database with Spring Boot to connect to H2 database.
Added some insert query in resource folder of project to populate dummy data at runtime.

#
Added resilience4j and AOP dependencies 
Added circuit breaker controller

#
Defined the fallback method for circuit breaker controller.
Fallback method is used for sending default response when the service is down.

Added the configuration in application files 
For max. number of retry , wait duration in each retry.