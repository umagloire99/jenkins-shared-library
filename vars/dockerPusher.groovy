import com.example.Docker

/* groovylint-disable-next-line MethodReturnTypeRequired, NoDef */
def call(String imageName) {
    return new Docker(this).pusherDocker(imageName)
}
