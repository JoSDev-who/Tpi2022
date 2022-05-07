
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
                        sh 'mvn -f pom.xml clean test'
                        
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
