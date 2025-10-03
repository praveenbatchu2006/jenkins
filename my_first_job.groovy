job('hello-world-job') {
    description('A Jenkins job that pulls a sample Maven project, installs Maven if needed, and runs mvn clean compile')
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
            echo "Pulling and building sample project"
            mkdir -p maven
            cd maven
            if [ ! -f apache-maven-3.9.11-bin.tar.gz ]; then
                wget https://dlcdn.apache.org/maven/maven-3/3.9.11/binaries/apache-maven-3.9.11-bin.tar.gz
            fi
            if [ ! -d apache-maven-3.9.11 ]; then
                tar xzf apache-maven-3.9.11-bin.tar.gz
            fi
            export PATH=$PWD/apache-maven-3.9.11/bin:$PATH
            cd ..
            mvn clean compile
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