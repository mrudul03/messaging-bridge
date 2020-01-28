## Service to send messages to IBM MQ queue

Compile the service

```
mvn clean install
```

Dockerize

```
docker build -t mrudul03/ibmmq-service:v01 .
docker run --network mq-demo-network -p 8081:8081 mrudul03/ibmmq-service:v01
```