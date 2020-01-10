## Message Router

User Apache Camel to routes messages.
It consumes messages from IBM MQ Queue and publishes the same to Active MQ Queue

## Active MQ Docker Image
docker pull rmohr/activemq
docker run -p 61616:61616 -p 8161:8161 rmohr/activemq

Active MQ Console
localhost:8161