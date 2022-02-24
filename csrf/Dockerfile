### STATIC LAYER
FROM openjdk:8-jdk-alpine as builder
LABEL MAINTAINER="Glenn ten Cate <glenn.ten.cate@owasp.org>"

### DYNAMIC LAYER
FROM builder
ARG CSRF_RUN=target/run.sh
COPY ${CSRF_RUN} /skf/run.sh
ARG CSRF_EVIL_JAR=target/evil-csrf.jar
COPY ${CSRF_EVIL_JAR} /skf/evil-csrf.jar
ARG JAR_FILE=target/csrf*.jar
COPY ${JAR_FILE} /skf/app.jar

### CREATING LIMITED USER AND CHAING WORKDIR FOLDER OWNERSHIP
RUN addgroup -S spring && adduser -S spring -G spring && chown -R spring:spring /skf

### SWITCHING TO THE LIMITED USER
USER spring:spring
WORKDIR /skf
ENTRYPOINT ["/bin/sh", "/skf/run.sh"]
