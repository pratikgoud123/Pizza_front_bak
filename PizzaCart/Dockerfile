FROM openjdk:11-jre-slim
WORKDIR usr/lib
ADD ./target/PizzaCart-0.0.1-SNAPSHOT.jar /usr/lib/PizzaCart-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","PizzaCart-0.0.1-SNAPSHOT.jar"]