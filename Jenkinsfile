pipeline {
	agent any
	parameters {
		choice(name: 'VERSION', choices: ['1.1.0','1.2.0','1.3.0'], description: 'Version to deploy on PROD')
		booleanParam(name: 'execTest', defaultValue: true, description: '')
	}
	stages {
		stage('Build'){			
			steps {
				echo "Building the application "
			}
		}
		
		stage('Test') {
			when {
				expression {
					params.execTest == true
				}
			}
			steps {
				echo "Testing the application"
			}
		}
		
		stage('Deploy') {
			steps {
				echo "Deploying the application"
				echo "This is the Version to deploy : ${params.VERSION}"				
			}
			
		}
	}

}