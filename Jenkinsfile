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
		
		stage('Compile') {
			steps {
				echo "Compiling the project ..."
				bat "mvn compile"
			}
			
		}
		
		stage('Deploy') {
			steps {
				echo "This is the Version to deploy : ${params.VERSION}"
				echo "Deploy the application ..."
				bat "mvn package"
			}
			
		}
		
	}
	
	post {
		success {
			archiveArtifacts artifacts: 'src/main/*.war', fingerprint: true
		}
	}

}