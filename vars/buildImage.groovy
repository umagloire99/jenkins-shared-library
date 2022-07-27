#!/usr/bin/env groovy

/* groovylint-disable-next-line MethodReturnTypeRequired, NoDef */
def call(String dockerImage) {
    echo 'building docker Image and push to docker hub ......'
    /* groovylint-disable-next-line LineLength */
    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t $dockerImage ."
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker push $dockerImage"
    }
}
