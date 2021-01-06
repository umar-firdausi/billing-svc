FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} billing-svc.jar
ENTRYPOINT ["java","-jar","/billing-svc.jar"]