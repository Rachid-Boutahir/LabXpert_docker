# Utiliser une image de base avec Java 11 JRE (Java Runtime Environment)
#FROM maven:3.3.2-jdk-17

# Copier le jar de l'application dans le conteneur
#COPY target/mon-application.jar /app/mon-application.jar

# Définir le répertoire de travail dans le conteneur
#WORKDIR /app

# Commande à exécuter lorsque le conteneur démarre
#CMD ["java", "-jar", "mon-application.jar"]
#======================================================================
#ARG MAVEN_VERSION=3.3.2
#ARG APP=testSecurity
#
#FROM maven:${MAVEN_VERSION}-openjdk-17-slim
#COPY target/${JAR_FILE} /${APP}/${JAR_FILE}
#WORKDIR /${APP}
#CMD ["java", "-jar", "${JAR_FILE}"]

#Voici comment vous pouvez construire votre image Docker en passant la variable d'environnement JAR_FILE :
#docker build --build-arg JAR_FILE=mon-application.jar -t mon-application .


FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
COPY target/geodev-0.0.1-SNAPSHOT.jar  geodev.jar
ENTRYPOINT ["java","-jar","/geodev.jar"]
