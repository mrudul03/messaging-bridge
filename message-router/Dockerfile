FROM openjdk:latest
VOLUME /root/.m2
EXPOSE 8082
WORKDIR /poc/
ADD target/message-router-0.0.1-SNAPSHOT.jar /poc/message-router.jar
ENTRYPOINT ["java", "-jar","/poc/message-router.jar"]