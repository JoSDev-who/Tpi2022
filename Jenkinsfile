pipeline {
    agent any
    stages {
        stage('Hello') {
            steps {
                script {
                                  if (isUnix()) {
            echo 'Hello from main unix'
        } else {
            sh "echo 'Hello from linux'"
        }
                    }
            }
        }
    }
}

