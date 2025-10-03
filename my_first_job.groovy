job('hello-world-job') {
    description('A Jenkins job that pulls a sample Maven project, installs Maven if needed, runs mvn clean compile, and builds a Docker image')
    scm {
        git {
            remote {
                url('https://github.com/spring-projects/spring-petclinic.git') // Sample Maven project
            }
            branch('main')
        }
    }
    steps {
        shell('''
            
            # Check if Dockerfile exists, create a basic one if not
            if [ ! -f Dockerfile ]; then
                cat > Dockerfile << 'EOF'
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
EOF
            fi
            docker build -t spring-petclinic:latest .
        ''')
    }
}

listView('my-jobs') {
    description('View containing all my jobs')
    jobs {
        name('hello-world-job')
    }
    columns {
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
        buildButton()
    }
}