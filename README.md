spring-boot-webapp
=================

example for spring-boot &amp; mybatis

#### 1、use maven to creating an executable jar(skip test)

mvn package -DskipTests

#### 2、running the web application

java -jar target/spring-boot-webapp-0.0.1-SNAPSHOT.jar

#### 3、open browser to test

localhost:8080

#### 4、running as a standalone application

change 

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
to
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter</artifactId>
</dependency>