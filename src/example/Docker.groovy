package com.example

class Docker implements Serializable {


    def script

    Docker(script) {
        this.script = script
    }

    def buildImage(String imageName) {
        script.echo 'building docker Image and push to docker hub ......'
    /* groovylint-disable-next-line LineLength */
       script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "docker build -t $imageName ."
            script.sh 'echo $script.PASS | docker login -u $script.USER --password-stdin'
            script.sh "docker push $imageName"
        }
    }

}
