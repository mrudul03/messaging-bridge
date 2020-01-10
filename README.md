# Messaging Bridge Sample

## Overview

## Architecture

## Go Build!

* ** Step 1: Deploy the on-premises IBM MQ broker ** 
Here, we are creating a Docker image which contains the IBM® MQ broker.

Clone the 'mq-container' GitHub project by running the following command:

```
git clone https://github.com/ibm-messaging/mq-container.git
```

Build the Docker image for IBM® MQ 9.0.5. In this step, we are creating the Docker image, by running the following commands:

```
cd mq-container

git checkout b751640b79a9a40031f23f9bb473aec68b691170

make build-devserver
```
Access IBM MQ Console using https://127.0.0.1:9443/ibmmq/console/

* ** Step 2: Deploy the on-premises Active MQ broker ** 
docker pull rmohr/activemq
docker run -p 61616:61616 -p 8161:8161 rmohr/activemq

Active MQ Console
localhost:8161

* ** Step 3: Build and run IBM MQ Servive ** 
IbmMQService (REST Service) to publish message to IBM MQ Queue.

```
mvn clean install
java -jar target/message-router-0.0.1-SNAPSHOT.jar
```

* ** Step 4:  Build and deploy Message Router **
Message Router to route messages from IBM MQ to Active MQ

```
mvn clean install
java -jar target/message-router-0.0.1-SNAPSHOT.jar
```