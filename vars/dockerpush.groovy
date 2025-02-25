def call(String DockerHubCred, String imageName){
  withCredentials([usernamePassword(
                    
                credentialsId: "${DockerHubCred}",
                usernameVariable: "DockerHubUser",
                passwordVariable: "DockerHubPass"
                    
                )]){
                
                sh "docker login -u ${env.DockerHubUser} -p ${env.DockerHubPass}"
                sh "docker image tag ${imageName} ${env.DockerHubUser}/${imageName}"
                sh "docker push ${env.DockerHubUser}/${imageName}:latest"
                }
}
