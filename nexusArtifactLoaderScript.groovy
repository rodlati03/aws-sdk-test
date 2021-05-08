def getLoadingArtifact() {
	nexusArtifactUploader(
                        nexusVersion: NEXUS_VERSION,
                        protocol: NEXUS_PROTOCOL,
                        nexusUrl: NEXUS_URL,
                        groupId: 'com.netflix.awssdktest',
                        version: version,
                        repository: NEXUS_REPOSITORY,
                        credentialsId: NEXUS_CREDENTIAL_ID,
                        artifacts: [
                            [artifactId: 'aws-sdk-test',
                             classifier: '',
                             file: 'target/aws-sdk-test.war',
                             type: 'war']
                        ]
                     )
}

return this
