#!/bin/sh

mvn clean install -Dmaven.test.skip=true -Pdev
cp  -r example-web/target/example-web-0.1-SNAPSHOT.war   /home/xiaog/tomcat_instance/webapps/example.war 

