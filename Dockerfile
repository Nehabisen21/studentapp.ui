# ---- Build Stage ----
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set the working directory
WORKDIR /app

# Copy the project files
COPY . .

# Build the WAR file
RUN mvn clean package -DskipTests

# ---- Runtime Stage ----
FROM tomcat:9.0.78-jdk17-temurin-jammy as runtime

# Copy WAR to Tomcat webapps
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/app.war

# Copy MySQL JDBC driver (make sure this is the correct version)
COPY mysql-connector.jar /usr/local/tomcat/lib/

# Expose port
EXPOSE 8080

# Run Tomcat
CMD ["catalina.sh", "run"]

