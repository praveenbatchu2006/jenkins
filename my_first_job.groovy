job('hello-world-job') {
    description('A Jenkins job that prints hello')
    steps {
        shell('echo hello')
    }
}

job('welcome-message-job') {
    description('A Jenkins job that prints a welcome message')
    steps {
        shell('echo Welcome to Jenkins!')
    }
}

job('status-check-job') {
    description('A Jenkins job that prints system status')
    steps {
        shell('echo System is running')
    }
}

job('test-environment-job') {
    description('A Jenkins job that prints test environment info')
    steps {
        shell('echo Running in test environment')
    }
}