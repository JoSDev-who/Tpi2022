
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'build...'
            }
        }
        stage('Test') {
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
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
