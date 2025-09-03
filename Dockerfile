# -------- Stage 1: Build with Maven --------
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

# -------- Stage 2: Runtime image --------
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy jar from builder
COPY --from=builder /app/target/log-processing-system-1.0.0.jar app.jar

# Create logs directory inside container
RUN mkdir -p /app/logs

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
