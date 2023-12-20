FROM openjdk:17-oracle

#WORKDIR /app

ARG PACKAGED_JAR=build/libs/courseWork5sem-0.0.1-SNAPSHOT.jar

ADD ${PACKAGED_JAR} app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
