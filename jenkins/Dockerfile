FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY target/jenkins-0.0.2-SNAPSHOT.jar /app
ENTRYPOINT ["java","-jar","jenkins-0.0.2-SNAPSHOT.jar"]