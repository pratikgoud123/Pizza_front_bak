FROM openjdk:11-jre-slim
WORKDIR usr/lib
ADD ./target/PizzaDelivery-0.0.1-SNAPSHOT.jar /usr/lib/PizzaDelivery-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","PizzaDelivery-0.0.1-SNAPSHOT.jar"]