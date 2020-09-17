# Start with a base image containing Java runtime
FROM openjdk:14-jdk-alpine

# Add Maintainer Info
LABEL maintainer="luispastre@hotmail.com"

ENV HOMEPATH=/

RUN mkdir -p /data/in
RUN mkdir -p /data/out
RUN mkdir -p /opt/agibank
RUN mkdir -p /opt/agibank/lib

ADD in /data/in

WORKDIR /opt/agibank

ADD target/lib /opt/agibank/lib

# The application's jar file
ARG JAR_FILE=target/agibanktest.jar

# Add the application's jar to the container
ADD ${JAR_FILE} agibanktest.jar


# Run the jar file 
ENTRYPOINT ["java","-jar","agibanktest.jar"]

CMD /bin/sh