# Messaging Bridge Sample

## Overview

## Architecture

## Go Build!

#### Step 1: Deploy the on-premises IBM MQ broker
Here, we are creating a Docker image which contains the IBM® MQ broker.

Pull IBM MQ Docker Image

```
docker pull ibmcom/mq:latest
```

Run the container from image

```
docker volume create qm1data
docker network create mq-demo-network
docker run --env LICENSE=accept --env MQ_QMGR_NAME=QM1 --volume qm1data:/mnt/mqm --publish 1414:1414 --publish 9443:9443 --network mq-demo-network --network-alias qmgr --detach --env MQ_APP_PASSWORD=passw0rd ibmcom/mq:latest
```

Access IBM MQ Console using https://127.0.0.1:9443/ibmmq/console/

#### Step 2: Deploy the on-premises Active MQ broker

```
docker pull webcenter/activemq:latest
docker run --network mq-demo-network --name='activemq' -d -e 'ACTIVEMQ_CONFIG_NAME=amqp-srv1' -p 8161:8161 -p 61616:61616 -p 61613:61613 webcenter/activemq:latest
```

Access Active MQ Console and create a queue named ACT.QUEUE.1
http://localhost:8161

#### Step 3: Build and run IBM MQ Servive
IbmMQService (REST Service) to publish message to IBM MQ Queue.

```
mvn clean install
docker build -t mrudul03/ibmmq-service:v01 .
docker run --network mq-demo-network -p 8081:8081 mrudul03/ibmmq-service:v01
```

#### Step 4:  Build and deploy Message Router
Message Router to route messages from IBM MQ to Active MQ

```
mvn clean install
docker build -t mrudul03/message-router:v01 .
docker run --network mq-demo-network -p 8082:8082 mrudul03/message-router:v01
```

#### Step 5:  Send message to IBM MQ Queue

POST a request to Ibmmq-Service

{
	"firstName": "Test-Message-First-Name",
	"lastName": "Test-Message-Last-Name",
	"gender": "Male",
	"age": 20
}
