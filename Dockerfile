FROM insideo/jre8
# MAINTAINER Feily <Feily.name@gmail.com>
ADD target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]