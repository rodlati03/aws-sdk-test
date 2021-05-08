def nexusLoadRelease
pipeline {
	agent any
	tools {
		maven "Maven"
	}
	environment {
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "192.168.1.129:8081"
        NEXUS_REPOSITORY = "maven-releases/"
        NEXUS_CREDENTIAL_ID = "my_nexus_credential"
    }
	parameters {
		choice(name: 'VERSION', choices: ['1.1.0','1.2.0','1.3.0'], description: 'Version to deploy on PROD')
		booleanParam(name: 'execTest', defaultValue: true, description: '')
	}
	stages {
	
		stage('Compile') {
			steps {
				echo "**************** Clean the project before ************** "
				bat "mvn clean"
				echo "Compiling the project ..."
			//	bat "mvn compile"
			}
			
		}

		/*
		stage('Test') {
			when {
				expression {
					params.execTest == true
				}
			}
			steps {
				echo "Testing the project ..."
				bat "mvn test"
			}
		}
		*/
		
		stage('Build'){			
			steps {
				echo "Building the code ..."					
				echo "This is the Version to deploy : ${params.VERSION}"
				echo "Deploy the application ..."
				bat "mvn package -DskipTests=true"
			}
			
		}
		
		stage('Load Groovy script'){			
			steps {
				script{
					nexusLoadRelease = load "nexusArtifactLoaderScript.groovy"
				}
			}
			
		}
		
		stage('Release to NEXUS Manager'){			
			steps {
			    
				script {
					nexusLoadRelease.getLoadingArtifact()
				}
			}
			
		}
		
	}
	
	post {
		success {
			echo "------------- COPY PACKAGE ARTIFCATS ---------------"
			archiveArtifacts artifacts: '**/target/aws-sdk-test.war', fingerprint: true
		}
	}

}