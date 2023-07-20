pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Here you would typically put build steps, but for simplicity, we're just echoing a message
                sh 'mvn clean install'
            }
        }
    }
}
