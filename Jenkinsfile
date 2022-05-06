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
                dir("${JENKINS_HOME}/workspace/BachesPipeTest") {
                sh 'mvn -B -DskipTests clean package'
                }
            }
        }
     }
    
}
