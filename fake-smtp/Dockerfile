FROM java:8

RUN mkdir -p /opt && wget -q http://nilhcem.github.com/FakeSMTP/downloads/fakeSMTP-latest.zip && unzip fakeSMTP-latest.zip -d /opt && rm fakeSMTP-latest.zip

VOLUME /output

RUN chmod +x /opt/fakeSMTP-2.0.jar

EXPOSE 25

CMD java -jar /opt/fakeSMTP-2.0.jar --start-server --background --output-dir /output --port 25