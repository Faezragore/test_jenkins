def remote = [:]
remote.name = "node"
remote.host = credentials('ip_adress')
remote.allowAnyHosts = true

node {
    withCredentials([usernamePassword(credentialsId: 'my_server_ruvds.com', passwordVariable: 'password_server', usernameVariable: 'user_server')]) {
        remote.user = user_server
        remote.password = password_server
        echo "$remote.user"
        echo "$remote.password"
        stage("SSH Steps Rocks!") {
            sh "ls -al"
        }
    }
}