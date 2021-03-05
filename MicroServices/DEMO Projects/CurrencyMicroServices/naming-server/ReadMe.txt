This is a Eureka Naming server also known as service registry.
Used for service discovery and load balancing.

Every MicroService will register istelf with Eureka Server when startup.
And MicroServices will request Eureka server to call other microservice 
And Eureka server will be providing address of to be called microservice.