FROM maven:3.8.6-openjdk-18 AS builder

ADD ./pom.xml pom.xml
ADD ./src src/

RUN mvn clean package -DskipTests

FROM openjdk:18

COPY --from=builder target/order-0.0.1-SNAPSHOT.jar order.jar

EXPOSE 3003

CMD ["java", "-jar", "order.jar"]
