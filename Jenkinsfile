
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
        
                echo 'test'
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
