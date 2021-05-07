pipeline {
	agent any
	parameters {
		choice(name: 'VERSION', choices: ['1.1.0','1.2.0','1.3.0'], description: 'Version to deploy on PROD')
		booleanParam(name: 'execTest', defaultValue: true, description: '')
	}
	stages {
		stage('Build'){			
			steps {
				echo "Building the code ..."
				bat "mvn clean"
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
		stage('Compile') {
			steps {
				echo "Compiling the project ..."
				bat "mvn compile"
			}
			
		}
		
		stage('Release and Deploy') {
			steps {							
				echo "This is the Version to deploy : ${params.VERSION}"
				echo "Deploy the application ..."
				bat "mvn package"
			}
			
		}
		
	}
	
	post {
		success {
			echo "------------- COPY PACKAGE ARTIFCATS ---------------"
			archiveArtifacts artifacts: '**/*_$BUILD_NUMBER.war', fingerprint: true
			echo ""
			echo "********************** RELEASE package to server NEXUS ********************* "
			bat 'curl -v -u admin:Sophtan@2018 --upload-file $FILE http://192.168.1.129:8081/repository/maven-releases/$MYREPO/$FILE'
		}
	}

}