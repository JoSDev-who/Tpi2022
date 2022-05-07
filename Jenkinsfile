
node ("windows") {
  stage ('Build') {

    git url: 'https://github.com/OM17028/Tpi2022'

    withMaven(
        // Maven installation declared in the Jenkins "Global Tool Configuration"
        maven: 'Tpi2022', // (1)
   
    ) {

      // Run the maven build
      sh "mvn clean verify"

    } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe & FindBugs & SpotBugs reports...
  }
}
