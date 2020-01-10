# Messaging Bridge Sample

## Overview

## Architecture

## Go Build!

#### Step 1: Deploy the on-premises IBM MQ broker
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
Run IBM MQ Docker Image

```
docker run -it --rm -e LICENSE=accept -e MQ_QMGR_NAME=QMGR -p 9443:9443 -p 1414:1414 mqadvanced-server-dev:9.1.0.0-x86_64-ubuntu-16.04
```
Access IBM MQ Console using https://127.0.0.1:9443/ibmmq/console/

#### Step 2: Deploy the on-premises Active MQ broker

```
docker pull rmohr/activemq
docker run -p 61616:61616 -p 8161:8161 rmohr/activemq
```

Access Active MQ Console
localhost:8161

#### Step 3: Build and run IBM MQ Servive
IbmMQService (REST Service) to publish message to IBM MQ Queue.

```
mvn clean install
java -jar target/message-router-0.0.1-SNAPSHOT.jar
```

#### Step 4:  Build and deploy Message Router
Message Router to route messages from IBM MQ to Active MQ

```
mvn clean install
java -jar target/message-router-0.0.1-SNAPSHOT.jar
```

#### Step 5:  Send message to IBM MQ Queue

POST a request to Ibmmq-Service

