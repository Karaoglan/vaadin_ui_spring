# Spring Boot Application with Vaadin UI plugin
spring boot application using mysql and vaadin ui plugin


## Getting Started
Below instruction will help you to run spring boot application with vaadin plugin

### Prerequisites
You have to provide proper dependency for spring boot application, its already defined in mvn root pom.

### Installing

* first create a new sql schema
```
"CREATE SCHEMA vaadingdemo;"
```
* then run create and insert scripts inside resources files in sql terminal.
* run maven command to create jar file under target in root folder of project
```
"mvn install"
```
* "cd target" and deploy 
```
"java -jar vaadindemo-0.0.1-SNAPSHOT.jar"
```
* good to go - its ready to departure at "localhost:8080"

## Authors
* **Burak Karaoglan ** - *Initial work* - [Burak Karaoglan](https://github.com/karaoglan)