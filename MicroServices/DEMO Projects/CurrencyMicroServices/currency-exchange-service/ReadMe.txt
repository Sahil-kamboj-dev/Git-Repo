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

#
Tried the @CircuitBreaker which is used for the 

Used windows cmd for firing multiple request per second as below :- 
for /l %g in () do @(curl http://localhost:8000/sample-api & timeout /t 0.2)
here curl http://localhost:8000/sample-api is used for api call..
the syntax for above command is as follows => for /l %g in () do @(<command> & timeout /t 5)

The use of Circuit Breaker is to provide the break when a particular service is down.
Circuit Breaker	Methodology is simple to not call the service if it is failing directly return the default fallback response.
Circuit Breaker has 3 states :-
Closed :- At start when everything is fine.
Open :- when certain no. of services are failing (can be configured) goes into the wait state. 
HalfOpen :- after wait is over try some %age of services  ( can be configured )  
			if getting response  { go back to closed } 
			else { go back to open state and again waits }
						
#
Tried @RateLimiter used for setting no. of calls per time.
Added config. related to RateLimiter.
Tried @Bulkhead used for number of requests at a time.