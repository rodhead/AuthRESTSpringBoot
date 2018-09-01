FROM openjdk:8-jdk-alpine
ADD target/resuth.jar resuth.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","resuth.jar"]
