FROM registry.cem-tech.cn/cem-jre8:1.0
MAINTAINER Feily <Feily.name@gmail.com>
ADD target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]