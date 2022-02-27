pipeline {
  agent any
  stages {
    stage('Compile') {
      steps {
        sh 'mvn compile'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }

    stage('Package') {
      steps {
        sh 'mvn package'
      }
    }

    stage('Archive Artifact') {
      steps {
        archiveArtifacts 'target/*.jar'
      }
    }

    stage('Publish Result') {
      steps {
        junit '**/*.xml'
      }
    }

  }
}