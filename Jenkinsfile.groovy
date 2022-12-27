myPipelineJobs = [MonitoringTest: 'https://gitlab.cee.redhat.com/ccit/monitoring-test.git']
myPipelineJobs.each { jobName, repoURL ->
    pipelineJob("$jobName") {
      description( "$repoURL" )
        authenticationToken('myverylongtoken')
        definition {
          cpsScm {
            scm {
            git {
                remote {
                  url("$repoURL")
                    }
                    extensions { }
                    }
                }
            }
        }
    }
}
