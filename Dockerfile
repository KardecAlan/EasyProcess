FROM maven:3.8-jdk-8-slim as build
WORKDIR /app
COPY . .
RUN mvn clean package
FROM tomcat:8.5.83-jdk8
COPY --from=build /app/target/EasyProcess.war /usr/local/tomcat/webapps/ROOT.war
