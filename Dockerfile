FROM insideo/jre8

MAINTAINER Feily <Feily.name@gmail.com>

ADD target/*.jar /opt/app.jar

WORKDIR /opt

ENTRYPOINT ["java", "-jar", "app.jar"]