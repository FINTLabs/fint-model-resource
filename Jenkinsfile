pipeline {
    agent none
    stages {
        stage('Build') {
            agent {
                docker {
                    label 'docker'
                    image 'gradle:4.6.0-jdk8-alpine'
                }
            }
            steps {
                sh 'gradle --no-daemon clean build'
                archiveArtifacts 'build/libs/*.jar'
            }
        }
        stage('Deploy') {
            agent {
                docker {
                    label 'docker'
                    image 'gradle:4.6.0-jdk8-alpine'
                }
            }
            environment {
                BINTRAY = credentials('fint-bintray')
            }
            when {
                tag pattern: "v\\d+\\.\\d+\\.\\d+(-\\w+-\\d+)?", comparator: "REGEXP"
            }
            steps {
                script {
                    VERSION = TAG_NAME[1..-1]
                }
                sh "echo Version is ${VERSION}"
                sh "gradle --no-daemon -Pversion=${VERSION} -PbintrayUser=${BINTRAY_USR} -PbintrayKey=${BINTRAY_PSW} bintrayUpload"
            }
        }
    }
}
