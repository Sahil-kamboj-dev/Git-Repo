This is Currency Conversion MicroService.

Purpose of this service to call currency-exchange microservice with required currency details.
currency-exchange microservice in response will provide the convresion rate for requested currency(if present in db).
#
Added Netflix Eureka Client dependency to pom.xml of both projects to register them with Eureka Server.
Now the load balancing and service discovery will be done by Netflix Eureka on the basis of application-server-name.