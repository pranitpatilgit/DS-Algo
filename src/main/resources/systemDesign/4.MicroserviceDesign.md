# Microservice Design Patterns
## Service Registry
- e.g. Consul, Eureka
- Every service registers itself at startup

## Circuit Breaker
- Needed to recover from external service failures
- Does not have to wait for timeouts
- e.g Spring cloud circuit breaker

## API Gateway
- Routing requests to appropriate microservice
- Proxy
- Decouple clients from microservices
- Additional layer of security
- Authentication and Authorization

## Saga
- Way to manage transactions across multiple microservices

## Event Sourcing
- Instead of storing current state store all events
- Application state can be reconstructed at any point using these events
- Auditability

## Command Query Responsibility Segregation (CQRS)
- Separate writes - Command
- Separate Reads - Query
- Both can be developed and optimized separately according to the needs
  - e.g. Write in MongoDB
  - Read from in memory DB
- Complicated to implement

## Backends for Frontends
- Separate Backends for different Frontends
- 2 different backends connecting to same API services for Mobile and Web App
- Can be scaled independently
- Hard to maintain
