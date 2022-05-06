pipeline {
    agent any

    tools {
        maven "Tpi2022"
    }

        stage('Build') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/restP']], extensions: [], userRemoteConfigs: [[credentialsId: 'whoamipc', url: 'https://github.com/OM17028/Tpi2022.git']]])
                sh 'mvn -Dmaven.test.failure.ignore=true clean package'
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
