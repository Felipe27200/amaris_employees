# Spring Boot Project Overview

## Framework
- Spring Boot v3.4.3

## JDK Version
- JDK 21

## Application Server
- WildFly 30.0.0.Final

## Deploying the Spring Boot Project
- Take the WAR file `juan-zea-employees-1.war` and place it in the WildFly deployment directory:

```
C:\wildfly-30.0.0.Final\standalone\deployments
```

- Start WildFly, and the deployment should already be active.

## Valid API Routes

- Get all employees:

```
http://HOST:PORT/juan-zea-employees-1/api/employees
```

- Get an employee by ID:

```
http://HOST:PORT/juan-zea-employees-1/api/employees/{id}
```

Where `{id}` is the ID of the employee.

