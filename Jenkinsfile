pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'java17-corretto'
    }

    environment {
        ALLURE_RESULTS = 'target/allure-results'
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'github-token', url: 'https://github.com/melihberk/selenium-with-cucumber.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: "${env.ALLURE_RESULTS}"]]
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/**/*.jar', fingerprint: true
        }

        failure {
            mail to: 'melihberkk@gmail.com',
                 subject: "❌ Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: """


Jenkins üzerinde ${env.JOB_NAME} job'u başarısız oldu.

Build detayları: ${env.BUILD_URL}

"""
        }
    }
}
