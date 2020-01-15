#!/bin/bash
javac -cp lib/mysql-connector-java-8.0.17.jar $(find . -name "*.java")
cd src
java -cp .:lib/mysql-connector-java-8.0.17.jar application.Main

rm $(find . -name "*.class")
