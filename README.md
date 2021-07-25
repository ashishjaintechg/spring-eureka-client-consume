# spring-eureka-client-consume
Discover service from another service from Eureka

This service calls another client service internall from eureka server by giving service name registerd.

CLIENT-SERVICE is registered with Eureka server which return greeting msg.

This service wraps ****<MSG>**** around greeting returned from CLIENT-SERVICE.

http://localhost:8182/wrapper/test

