pipeline {
    agent any

    stages {
       stage ('Scan and Build Jar File') {
            steps {
               withSonarQubeEnv('sonarserver') {
                bat 'clean install sonar:sonar'
                }
            }
        }
    }
}