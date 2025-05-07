pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository
                git 'https://github.com/KubaRajewski/backendConstructionApp'
            }
        }

        stage('Build') {
            steps {
                // Run Maven build (clean and install)
                script {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Post Build') {
            steps {
                // You can add any additional steps here (e.g., testing, deployment)
                echo 'Build and Tests completed!'
            }
        }
    }

    post {
        success {
            echo 'Build completed successfully'
        }
        failure {
            echo 'Build failed'
        }
    }
}