pipeline {
    agent any

    tools {
        maven "Tpi2022"
        jdk "jdk11"
    }

    stages {
        stage('Initialize'){
            steps{
                echo "PATH = ${M2_HOME}/bin:${PATH}"
                echo "M2_HOME = /opt/maven"
            }
        }
        stage('Build') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/restP']], extensions: [], userRemoteConfigs: [[credentialsId: 'whoamipc', url: 'https://github.com/OM17028/Tpi2022.git']]])
                sh 'mvn -Dmaven.test.failure.ignore=true clean package'
            }
        }
     }
    post {
       always {
          junit(
        allowEmptyResults: true,
        testResults: '*/test-reports/.xml'
      )
      }
   } 
}
