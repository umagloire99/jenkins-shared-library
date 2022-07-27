import com.example.Docker

/* groovylint-disable-next-line MethodReturnTypeRequired, NoDef */
def call() {
    return new Docker(this).dockerLogin()
}
