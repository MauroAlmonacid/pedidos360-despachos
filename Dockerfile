# =========================
# Etapa 1: Build (Maven + JDK 17)
# =========================
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copiar el POM primero para aprovechar el cache de dependencias
COPY pom.xml .
RUN mvn -B dependency:go-offline

# Copiar el código fuente y compilar el JAR
COPY src ./src
RUN mvn -B clean package -DskipTests

# =========================
# Etapa 2: Runtime (JRE 17)
# =========================
FROM eclipse-temurin:17-jre

WORKDIR /app

# Usuario no root por seguridad
RUN groupadd -r spring && useradd -r -g spring spring

COPY --from=build /app/target/*.jar app.jar

RUN chown -R spring:spring /app
USER spring

EXPOSE 8084

ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
