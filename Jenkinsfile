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
                sh 'mvn clean install'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
