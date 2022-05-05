pipeline {
       agent any
       
       environment{
       PATH=""
       }
       
       stages("clone repo"){
              steps{
              git credentialId:'git_credentials', url:'https://github.com/OM17028/Tpi2022.git'
              }
       }
       
        stages("build p"){
              steps{
              sh 'mvn clean install'
              }
       }
       
       
       
}
