
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'build...'
                bat "mvn -T 4 -B --batch-mode -V -U -e -Dmaven.test.failure.ignore clean package -Dmaven.test.skip=true"
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
