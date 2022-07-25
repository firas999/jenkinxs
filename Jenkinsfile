pipeline {
    agent any

    stages {
       stage ('Scan and Build Jar File') {
            steps {
               withSonarQubeEnv('sonarserver') {
                sh 'mvn clean package sonar:sonar'
                }
            }
        }
    }
}