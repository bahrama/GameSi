#!/bin/bash
echo "Starting wildfly project ...."
git clone https://github.com/bahrama/GameSi.git
git pull origin main
mvn clean
mvn install
bash
