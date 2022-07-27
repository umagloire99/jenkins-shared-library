#!/usr/bin/env groovy

/* groovylint-disable-next-line MethodReturnTypeRequired, NoDef */
def call() {
    echo 'building docker Image and push to docker hub ......'
    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t umagloire/demo-app:2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push umagloire/demo-app:2.0'
    }
}