FROM openjdk:11-jre-slim
WORKDIR usr/lib
ADD ./target/EurekaServer-0.0.1-SNAPSHOT.jar /usr/lib/EurekaServer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","EurekaServer-0.0.1-SNAPSHOT.jar"]
