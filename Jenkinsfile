
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'build...'
                bat "mvn test"
            }
        }
        stage('Test') {
            steps {
                script {
                    if (isUnix()) {
                        
                        
                        echo 'Hello from main unix'
                    } else {
                        bat "call mvn clean"
                        
                        echo "echo 'Hello from windo'"
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
