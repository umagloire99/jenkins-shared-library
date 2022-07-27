package com.example

class Docker implements Serializable {


    def script

    /* groovylint-disable-next-line MethodParameterTypeRequired */
    Docker(script) {
        this.script = script
    }

    /* groovylint-disable-next-line NoDef */
    def buildImage(String imageName) {
        script.echo 'building docker Image ......'
        script.sh "docker build -t $imageName ."
    }

    def dockerLogin() {
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
        }
    }

    /* groovylint-disable-next-line DuplicateStringLiteral */
    def pusherDocker(String imageName) {
        script.echo 'Pushing to docker hub ......'
        script.sh "docker push $imageName"
    }
}
