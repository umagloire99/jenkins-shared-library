#!/usr/bin/env groovy

def call() {
    echo 'building JAR file ......'
    sh 'mvn package'
}