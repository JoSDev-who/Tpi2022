pipeline {
    agent any
    stages {
        stage('Hello') {
            steps {
                script {
                                  if (isUnix()) {
            echo 'Hello from main unix'
        } else {
            echo "echo 'Hello from linux'"
        }
                    }
            }
        }
    }
}

