pipeline{

agent any

parameters {
  choice choices: ['chrome', 'firefox'], description: 'select a browser', name: 'BROWSER'
}

stages{

stage('Bring up the grid'){

steps{

bat "docker-compose -f grid.yaml up --scale ${params.BROWSER}=1 -d"

}

}

stage('Run the tests'){

steps{

bat 'docker-compose -f test-suites.yaml up'

}

}

stage('Bring down the containers'){

steps{
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