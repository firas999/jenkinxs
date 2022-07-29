FROM openjdk:8-jdk-alpine 
WORKDIR webapps 
COPY target/ExamTemplate-1.0.jar .
ENTRYPOINT ["java","-jar","*.jar"]
