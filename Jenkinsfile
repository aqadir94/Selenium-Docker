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
    
bat 'docker build aqadir9456/seleniium'
}
    
}

stage('Push Image'){
steps{

bat 'docker push aqadir9456/seleniium'
}
    
}

}



}