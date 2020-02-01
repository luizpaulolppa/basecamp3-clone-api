# Basecamp 3 (clone)

# Dependencies

1) Install [JDK 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html) and configure enviroments

2) Install Apache [Maven](https://maven.apache.org/download.cgi) 3.6.3 and configure enviroments

3) Install [Docker](https://docs.docker.com/install/).

4) Clone [repository](https://github.com/luizpaulolppa/basecamp3-clone-api) in same directory.

# Application setup

        1) Create database Postgres with this command line:
            $ docker run -d --name postgres -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PESSWORD=postgres -e POSTGRES_DB=basecamp_dev postgres

        2) Start Java Application "BasecampApiApplication" class in  your IDE or use this command line $ mvn spring-boot:run.

        # The application will start at `localhost:8080/api` \o/