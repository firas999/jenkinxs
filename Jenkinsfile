pipeline {
    agent any

    stages {
       stage ('Scan and Build Jar File') {
            steps {
               withSonarQubeEnv('sonarserver') {
                bat 'mvn clean package sonar:sonar'
                }
            }
        }
    }
}