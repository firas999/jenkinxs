def getDockerTag(){
        def tag = bat script: 'git rev-parse HEAD', returnStdout: true
        return tag
        }
pipeline{

      agent any
         environment{
	    Docker_tag = getDockerTag()
        }
        stages{

              stage('Quality Gate Status Check'){
                  steps{
                      script{
			      withSonarQubeEnv('sonarserver') { 
			      bat 'C:/Users/dell/Downloads/apache-maven-3.8.6-bin/apache-maven-3.8.6/bin/mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install'
			      bat 'C:/Users/dell/Downloads/apache-maven-3.8.6-bin/apache-maven-3.8.6/bin/mvn  sonar:sonar'
                       	     	}
			      timeout(time: 1, unit: 'HOURS') {
			      def qg = waitForQualityGate()
				      if (qg.status != 'OK') {
					   error "Pipeline aborted due to quality gate failure: ${qg.status}"
				      }
                    		}
		    	    bat 'C:/Users/dell/Downloads/apache-maven-3.8.6-bin/apache-maven-3.8.6/bin/mvn clean  install'
		  
                 	}
               	 }  
              }
              stage('build')
                {
              steps{
                  script{
                  bat 'docker build C:/Users/dell/.jenkins/workspace/DemoPipeline/target -t 123anz/jenkins:$Docker_tag'
		  withCredentials([string(credentialsId: 'dockerPASS', variable: 'docker_password')]) {			    
				  bat 'docker login -u 123anz -p $docker_password'
				  bat 'docker push 123anz/jenkins:$Docker_tag'
			}
                       }
                    }
                 }	
		
            }	       	     	         
}