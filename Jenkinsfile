pipeline {
    agent any
//
//     tools {
//         maven 'MAVEN_HOME'   // Configure Maven in Jenkins Global Tool Configuration
//         jdk 'JAVA_HOME'      // Configure JDK in Jenkins Global Tool Configuration
//     }

    stages {
        stage('Checkout') {
            steps {
                // Pull your repo from Git
                'https://github.com/TripleDartPlatform/TripleDartQA_Automation.git'
            }
        }

        stage('Build & Run Cucumber Tests') {
            steps {
                // This runs your JUnit Cucumber Runner
                sh 'mvn clean test'
            }
        }

        stage('Publish Cucumber HTML Report') {
            steps {
                // Publish cucumber-report.html from target folder
                publishHTML([
                    reportDir: 'target',
                    reportFiles: 'cucumber-report.html',
                    reportName: 'Cucumber HTML Report',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
                ])
            }
        }

        stage('Publish Cucumber JSON Report') {
            steps {
                cucumber buildStatus: 'UNSTABLE',
                        fileIncludePattern: 'target/cucumber.json',
                        trendsLimit: 10
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'   // Parse JUnit XML results
        }
    }
}