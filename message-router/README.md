## Message Router

User Apache Camel to routes messages.
It consumes messages from IBM MQ Queue and publishes the same to Active MQ Queue

```
mvn clean install
java -jar target/message-router-0.0.1-SNAPSHOT.jar
```

docker build -t mrudul03/message-router:v01 .
docker run -p 8082:8082 mrudul03/message-router:v01