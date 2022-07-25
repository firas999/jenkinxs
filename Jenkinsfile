pipeline {
    agent any

    stages {
       stage ('Scan and Build Jar File') {
            steps {
               withSonarQubeEnv('sonarserver') {
                start 'mvn clean package sonar:sonar'
                }
            }
        }
    }
}