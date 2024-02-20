# Use a base image with Java already installed


# # Set the working directory in the container
# WORKDIR /app

# # Copy the compiled Java web application (e.g., .war file) into the container
# COPY target/FitnessTracking.war /app

# # Expose the port your Java web application runs on
# EXPOSE 8081

# # Command to run your Java web application
# CMD ["java", "-jar", "FitnessTracking.war"]

FROM maven:3.9.5-eclipse-temurin-17-alpine AS build
LABEL authors=" "


WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests -X


FROM quay.io/wildfly/wildfly:26.1.3.Final-jdk17 AS deploy


COPY --from=build /app/target/FitnessTracking.war /opt/jboss/wildfly/standalone/deployments/



EXPOSE 8081

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]