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
                if (isUnix()) {
            echo 'Hello from main unix'
        } else {
            sh "echo 'Hello from linux'"
        }
              
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
