pipeline {
    agent any
    stages {
        stage('Compile') {
            steps {
                writeFile file: 'Addition.java', text: '''
                public class Addition {
                    public static void main(String[] args) {
                        int a = 10, b = 20;
                        int sum = a + b;
                        System.out.println("The sum is: " + sum);
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
