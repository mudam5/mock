pipeline {
  agent any

  environment {
    MVN_CMD = "mvn"
    DOCKER_REGISTRY = "your-dockerhub-username"   // e.g., "docker.io/myuser"
    DOCKER_REPO = "log-processing-system"
    DOCKER_TAG = "latest"
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build') {
      steps {
        sh "${env.MVN_CMD} -B clean package"
      }
    }

    stage('Unit Tests') {
      steps {
        sh "${env.MVN_CMD} -B test"
        junit 'target/surefire-reports/*.xml'
      }
    }

    stage('Archive') {
      steps {
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }

    stage('Docker Build') {
      steps {
        script {
          sh """
            docker build -t ${DOCKER_REGISTRY}/${DOCKER_REPO}:${DOCKER_TAG} .
          """
        }
      }
    }

    stage('Docker Push') {
      steps {
        script {
          // login using Jenkins credentials
          withCredentials([usernamePassword(credentialsId: 'docker-hub-creds',
                                           usernameVariable: 'DOCKER_USER',
                                           passwordVariable: 'DOCKER_PASS')]) {
            sh "echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin ${DOCKER_REGISTRY}"
            sh "docker push ${DOCKER_REGISTRY}/${DOCKER_REPO}:${DOCKER_TAG}"
          }
        }
      }
    }
  }

  post {
    success {
      echo "Build and Docker push succeeded"
    }
    failure {
      echo "Pipeline failed"
    }
    always {
      cleanWs()
    }
  }
}
