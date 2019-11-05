# Applications' status

> I have used Project Lombok, you may want to refer [this link](https://projectlombok.org/setup/eclipse) to configure Project Lombok in Eclipse

###### Architectural diagram 

![](https://github.com/ashishb888/spring-boot-poc/blob/master/apps-status/diagrams/apps-status1.PNG)

###### Technologies stack

<pre>
Language: Java 8
Framework: Spring boot 2.1.6.RELEASE
Build system: Maven 3.2+
Bash scripts
</pre>

###### Package
` mvn package `

###### Run
` nohup $JAVA_HOME/bin/java -jar apps-status-0.0.1-SNAPSHOT.jar > /dev/null 2>&1 & `