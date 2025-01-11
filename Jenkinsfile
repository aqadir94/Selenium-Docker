pipeline {

    agent any

    parameters {
        choice(
            choices: ['chrome', 'firefox'],
            description: 'Select a browser',
            name: 'BROWSER'
        )
    }

    stages {

        stage('Build Jar') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t=aqadir9456/seleniium .'
            }
        }

        stage('Push Image') {
            environment {
                DOCKER_HUB = credentials('docker-creds')
            }
            steps {
                bat 'docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%'
                bat 'docker push aqadir9456/seleniium'
            }
        }

        stage('Logout') {
            steps {
                bat 'docker logout'
            }
        }

        stage('Bring Up the Grid') {
            steps {
                bat "docker-compose -f grid.yaml up --scale chrome=1 -d --pull=always"

            }
        }

        stage('Run the Tests') {
            steps {
                bat 'docker-compose -f test-suites.yaml up'
            }
        }

        stage('Bring Down the Containers') {
            steps {
                bat 'docker-compose -f grid.yaml down'
                bat 'docker-compose -f test-suites.yaml down'
            }
        }

    }

    post {
        always {
            archiveArtifacts artifacts: 'output/vendor-portal/emailable-report.html', followSymlinks: false
        }
    }

}
