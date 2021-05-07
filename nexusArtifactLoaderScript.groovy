def getLoadingArtifact() {
	nexusArtifactUploader {
        nexusVersion('nexus3')
        protocol('http')
        nexusUrl('192.168.1.129:8081')
        groupId('com.jojo.tuto')
        version('1.4')
        repository('maven-releases')
        credentialsId('my_nexus_credential')
        artifact {
            artifactId('aws-sdk-test')
            type('war')
            classifier('debug')
            file('aws-sdk-test.war')
        }
        artifact {
            artifactId('aws-sdk-test')
            type('hpi')
            classifier('debug')
            file('aws-sdk-test.hpi')
        }
	}
}

return this
