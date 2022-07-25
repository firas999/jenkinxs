pipeline {
    agent any

    stages {
       stage ('Scan and Build Jar File') {
            steps {
               withSonarQubeEnv('sonarserver') {
                bat 'C:/Users/dell/Downloads/apache-maven-3.8.6-bin/apache-maven-3.8.6/bin/mvn clean package sonar:sonar'
                }
            }
        }
    }
}