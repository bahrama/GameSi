#!/bin/bash
echo "Starting wildfly project ...."
git clone https://github.com/bahrama/GameSi.git
git pull origin main
cp -R GameSi/postgresql wildfly-30.0.0.Final/modules/system/layers/base/org/
cp -R GameSi/persistance wildfly-30.0.0.Final/modules/system/layers/base/org/eclipse/
cp GameSi/statndalone.xml wildfly-30.0.0.Final/standalone/configuration
cd GameSi
.././apache-maven-3.9.5/bin/mvn clean
.././apache-maven-3.9.5/bin/mvn install
bash
