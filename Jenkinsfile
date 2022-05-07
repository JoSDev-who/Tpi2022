pipeline {
    agent any

    stages {
        stage('step1'){
                        if (isUnix()) {
            echo 'Hello from main unix'
        } else {
            sh "echo 'Hello from linux'"
        }
        }
        stage('Build') {
            steps {
                echo 'build...'
            }
        }
    }
        stage('Test') {
            steps {
        echo 'test'
              
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
