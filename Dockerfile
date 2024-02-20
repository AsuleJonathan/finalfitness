# Use a base image with Java already installed
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the compiled Java web application (e.g., .war file) into the container
COPY target/FitnessTracking.war /app

# Expose the port your Java web application runs on
EXPOSE 8080

# Command to run your Java web application
CMD ["java", "-jar", "FitnessTracking.war"]
