pipeline{

agent any

stages{

stage('Build Jar'){

steps{

bat 'mvn clean package -DskipTests'

}

}

stage('Build docker image'){



steps{
    
bat 'docker build -t=aqadir9456/seleniium .'
}
    
}

stage('Push Image'){
environment{
DOCKER_HUB=credentials('docker-creds')
}
steps{

bat 'echo %DOCKER_HUB_PSW% | docker login -u %DOCKER_HUB_USR% --password-stdin'
bat 'docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%'
bat 'docker push aqadir9456/seleniium'
}
    
}

}

post{
	
	always{
		
		bat "docker logout"
	}
}

}