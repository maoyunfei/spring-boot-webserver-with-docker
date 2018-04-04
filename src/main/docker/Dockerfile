FROM java:8
COPY webservice-demo-0.0.1-SNAPSHOT.jar /usr/src/demoapp/app.jar
WORKDIR /usr/src/demoapp
RUN apt-get update && apt-get install -y net-tools
ENTRYPOINT ["java","-jar","app.jar"]