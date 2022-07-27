#!/usr/bin/env groovy
import com.example.Docker

/* groovylint-disable-next-line MethodReturnTypeRequired, NoDef */
def call(String dockerImage) {
    return new Docker(this).buildImage(dockerImage)
}
