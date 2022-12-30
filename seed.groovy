node {
    stage('seed job checkout') {
        git url: 'https://github.com/ashutoshJadhav8/demo-JCASC-GIT.git', branch: 'main'
    }
    stage('pipelineMap jobs') {
        jobList = sh (script: """ git ls-tree --full-tree -r --name-only HEAD|egrep -iv "default|readme.md|.groovy" | sed -e "s/.yaml//" | egrep
           """)
        jobList.each{
            def folderName = it.split('/')[0]
            def jobName = it.split('/')[1]
            log.info "Pipelinemap folderName $(folderName)"
            log.info "Pipelinemap jobName $(folderJob)"
            jobDsl scriptText """
                pipelineJob("${folderName}/${jobName}"){
                    parameters{
                        stringParam('app8ranch', 'develop')
                    }
                    definition {
                        cps {
                            sandbox(true)
                            script("cicd()")
                        }
                    }
                }
            """
        }
    }
}
