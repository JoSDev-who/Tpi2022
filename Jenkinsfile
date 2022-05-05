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
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
