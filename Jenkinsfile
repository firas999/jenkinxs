pipeline{

      agent any
        
        stages{

              stage('Quality Gate Status Check'){
                  steps{
                      script{
			      withSonarQubeEnv('sonarserver') { 
			      bat 'C:/Users/dell/Downloads/apache-maven-3.8.6-bin/apache-maven-3.8.6/bin/mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install'
			      bat 'C:/Users/dell/Downloads/apache-maven-3.8.6-bin/apache-maven-3.8.6/bin/mvn clean  sonar:sonar'
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
		
            }	       	     	         
}