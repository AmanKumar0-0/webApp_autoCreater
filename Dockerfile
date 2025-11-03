FROM maven:3.9.8-eclipse-temurin-17

WORKDIR /app

COPY . .

RUN chmod +x mvnw || true

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/demo.appproject-0.0.1-SNAPSHOT.jar"]

