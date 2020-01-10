## Service to send messages to IBM MQ queue


## Run IBM MQ Docker Image
docker run -it --rm -e LICENSE=accept -e MQ_QMGR_NAME=QMGR -p 9443:9443 -p 1414:1414 mqadvanced-server-dev:9.1.0.0-x86_64-ubuntu-16.04


docker run -it --rm -e LICENSE=accept -e MQ_QMGR_NAME=QMGR -p 9443:9443 -p 1414:1414 mqadvanced-server-dev:9.1.0.0-x86_64-ubuntu-16.04