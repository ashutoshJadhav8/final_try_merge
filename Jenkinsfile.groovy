jobs:
#  - url: https://gitlab.cee.redhat.com/ccit/monitoring-seed/raw/master/seed.groovy
#  - url: https://gitlab.cee.redhat.com/strimzi/strimzi-ci/raw/master/src/jenkins/casc/jobs/tools/seeds/seed.groovy
  - script: >
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
