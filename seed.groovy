unclassified:  
  globalLibraries:
    libraries:
      - defaultVersion: "master"
        name: "strimzi-ci"
        retriever:
          modernSCM:
            scm:
              git:
                remote: "https://github.com/ashutoshJadhav8/final_try_merge.git"
                traits:
                  - "gitBranchDiscovery"
jobs:
  - script: >
      pipelineJob('seed') {
        definition {
          cps {
            sandbox(true)
            scrip("seed()")
          }

        }
      }
