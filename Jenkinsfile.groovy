pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/KhaledaAlRusan/Assignemnt2.git'
            }
        }

        stage('Build Maven Project') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker build') {
            steps {
                sh 'docker build -t khaled/Assignemnt2 .'
            }
        }

        stage('Docker login') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                }
            }
        }

        stage('Docker push') {
            steps {
                sh 'docker push khaled/Assignemnt2'
            }
        }

        stage('Docker run') {
            steps {
                sh 'docker run -d -p 8080:8080 khaled/Assignemnt2'
            }
        }
    }
}
