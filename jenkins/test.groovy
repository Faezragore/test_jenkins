node('my_server_linux') {
    stage('test') {
        name = "test1"
        host = credentials('ip_adress')
        allowAnyHosts = true

            withCredentials([usernamePassword(credentialsId: 'my_server_ruvds.com', passwordVariable: 'password_server', usernameVariable: 'user_server')]) {
                user = user_server
                password = password_server
                echo "$user"
                stage("SSH Steps Rocks!") {
                    sh "ls -al"
                }
            }
    }
}