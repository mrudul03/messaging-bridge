## Service to send messages to IBM MQ queue

```
mvn clean install
java -jar target/message-router-0.0.1-SNAPSHOT.jar
```

```
docker build -t mrudul03/ibmmq-service:v01 .
docker run --network mq-demo-network -p 8081:8081 mrudul03/ibmmq-service:v01
```