FROM openjdk:latest
VOLUME /root/.m2
EXPOSE 8081
WORKDIR /poc/
ADD target/ibmmq-service-0.0.1-SNAPSHOT.jar /poc/ibmmq-service.jar
ENTRYPOINT ["java", "-jar","/poc/ibmmq-service.jar"]