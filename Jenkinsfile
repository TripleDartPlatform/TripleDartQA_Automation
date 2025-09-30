pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/TripleDartPlatform/TripleDartQA_Automation.git'
            }
        }
        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
        stage('Publish Cucumber Reports') {
            steps {
                cucumber buildStatus: 'UNSTABLE',
                         fileIncludePattern: 'target/cucumber-reports.json',
                         jsonReportDirectory: 'target'
            }
        }
    }
}