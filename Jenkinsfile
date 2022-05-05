pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh "mvn clean compile test"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
