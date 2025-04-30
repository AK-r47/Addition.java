pipeline {
    agent any
    stages {
        stage('Compile') {
            steps {
                writeFile file: 'Addition.java', text: '''
                public class Addition {
                    public static void main(String[] args) {
                        int a = 5, b = 10;
                        System.out.println("Sum: " + (a + b));
                    }
                }
                '''
                bat 'javac Addition.java'
            }
        }
        stage('Run') {
            steps {
                bat 'java Addition'
            }
        }
    }
}
