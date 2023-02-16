FROM maven:3.8.6-openjdk-18 AS builder

ADD ./pom.xml pom.xml
ADD ./src src/

RUN mvn clean package

FROM openjdk:18

COPY --from=builder target/Buyer-0.0.1-SNAPSHOT.jar Buyer.jar

EXPOSE 3002

CMD ["java", "-jar", "Buyer.jar"]