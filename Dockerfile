FROM java:8

WORKDIR /opt

ADD ./target/mail-rest-*-jar-with-dependencies.jar /opt/mailRest.jar

RUN chmod +x /opt/mailRest.jar

ENTRYPOINT ["java","-jar","/opt/mailRest.jar"]

EXPOSE 8080