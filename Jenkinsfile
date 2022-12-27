def buildNode = "${env.LABEL}"
//node("${buildNode}")
pipeline{
    //currentBuild.result = "SUCCESS"
    //currentBuild.description = "${env.VM_IP}"
    agent any
    parameters{
        choice(name: 'Default nodes', choices: ['Master', 'beaker-rhel8-vm1', 'beaker-rhel8-vm2', 'beaker-rhel9-vm3','beaker-rhel9-vm4','cpt-ppc-001','cpt-ppc-003','cpt-ppc-006','cpt-ppc-040','cpt-ppc-041','cpt-ppc-042','cpt-ppc-043','cpt-ppc-044','cpt-ppc-045','cpt-ppc-046','cpt-ppc-047','cpt-ppc-048','cpt-ppc-049','cpt-ppc-051','kvm-rhel7-vm1','kvm-rhel7-vm2','openstack-x86-fedora-pratham','openstack-x86-rhel8-vm1','openstack-x86-rhel8-vm2','openstack-x86-rhel8-vm3','openstack-x86-rhel8-vm4','openstack-x86-rhel8-vm5','openstack-x86-rhel8-vm6','powervs-mon01-410c1','powervs-rhel8-vm1','powervs-tor01-410c1','rhv-rhel8-vm1','rhv-rhel8-vm2','rhv-rhel8-vm3','rhv-rhel8-vm4','rhv-rhel9-vm1'], description: 'The nodes used when job gets triggered by anything else other than manually')  
        choice(name: 'Possible nodes', choices: ['ALL (no restriction)','Master', 'beaker-rhel8-vm1', 'beaker-rhel8-vm2', 'beaker-rhel9-vm3','beaker-rhel9-vm4','cpt-ppc-001','cpt-ppc-003','cpt-ppc-006','cpt-ppc-040','cpt-ppc-041','cpt-ppc-042','cpt-ppc-043','cpt-ppc-044','cpt-ppc-045','cpt-ppc-046','cpt-ppc-047','cpt-ppc-048','cpt-ppc-049','cpt-ppc-051','kvm-rhel7-vm1','kvm-rhel7-vm2','openstack-x86-fedora-pratham','openstack-x86-rhel8-vm1','openstack-x86-rhel8-vm2','openstack-x86-rhel8-vm3','openstack-x86-rhel8-vm4','openstack-x86-rhel8-vm5','openstack-x86-rhel8-vm6','powervs-mon01-410c1','powervs-rhel8-vm1','powervs-tor01-410c1','rhv-rhel8-vm1','rhv-rhel8-vm2','rhv-rhel8-vm3','rhv-rhel8-vm4','rhv-rhel9-vm1'], description: 'The nodes used when job gets triggered by anything else other than manually')  
        string(name: 'VM_IP', defaultValue: '', description: 'IP address of remote VM to be configured')
        string(name: 'VM_USERNAME', defaultValue: 'root', description: 'Username to be used to access the remote VM')
        password(name: 'VM_PASSWORD', defaultValue: '****', description: 'Password to be used to access the remote VM')
        choice(name: 'RH_SUBS_ENABLED', choices: ['false', 'true'], description: 'Select true if RH subscription is to be enabled on the target VM, else select false')
        string(name: 'RH_SUBS_USERNAME', defaultValue: 'prathamm', description: 'RedHat subscription username')
        password(name: 'RH_SUBS_PASSWORD', defaultValue: '****', description: 'RedHat subscription password')
        string(name: 'SSH_KEY_BEAKER', defaultValue: 'ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQC7RdnIS/zy4X/YFzBCRSjVzbcB1xDP5Y9tyrVwVRHa8ASsDKdyAnV+c8NuuVUuoqD1VPdg8Ou7ivB8dxGX2EWwCTrLs7mq+y6HI045st1h9Q+DAQ5RaPg8DPrGghqbPsh5r6kLGpD8ETutg62ZSSc6Mj+2+oIIr8ksKKE/EzuJvdaENEEMV2Hr8XuJgZzlZFqdU4rs6clRrxEz5mtMY2V0gsNdN8oSCY22lpauVIwy/jZEWB+g0geUD0Cf9VXYhgn8OcqdSh6gJN08LTU7aQXcOG+hCop9Z5JVlICxWZae1aFlLv3noR3yrFAJz54u/skvHZVpRCSejOucNff3+xUz0qYABLQz3+iiatb9+pdrDmQt1X7wfJDX/YG28SAzMiefj/ufF5yliqqwHq5t9WYsMRabCVFlffa3V5/9Od+QM//sk39zk7h2+npiBscjv3tRu+tnZqQw0iMEFkwm2JqcAhSvxLoSisReQP7XurmNBjMaJFshVRZS4iZieWGobigS4oeZ+igSakjq//TH8+wz0cztzYa2sS1zoC4WzJ+7o9E2zGTlagkTz71IAyuO1tyVrHNCvpr4CKOLkhcyHKxvl4wh/Y9l4RMQnb2wtSvUpA2eEBgRjBBo3BeBPeuGxEz6g2pKdMElgijgdVZ0pMBpYPHbnSoWN3z0v5TDBxU9rw== bankingplays@beaker.casc', description: 'Public SSH key to be added to /root/.ssh/authorized_keys for accessing VMs created on beaker environment')
        string(name: 'SSH_KEY_OPENSTACK', defaultValue: 'ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQDkGMr9etxO5C2aSPYMSx2Sdt8m1tSNpAMwxipTMvveBtNb5LdyfPH0aBr40ueAzGVWaSQ3N2Hho9S3yzC7cG4PQDBlDlqPdaq/tLJKdZpkUVaOVXfKU+Z4BikHWlS4sZB7B2YocxPhsSKRjV925qwSrnFL3mjfLCoc3EnXIZmzRwbVv3L/LXyNTsYMkkAJhAvaUqFfcbtbW+Y2mdrw6BqtWK/wrd17MzJqWqJkSVYl2Y0bSg2RJl0BC2ND7CaBICSh+Z9hQkydrdp298UgVcKALPyJGdllVwrE9NczYUGbUZY2c0xsgZPTwMUP/hp14E+Kohu/flY2nrg4iHK4hJJUh8zaEdfG4xwUMvKEqk5JZeX61Y41WAT1UTzF6vXWjo1CL7hGvpLJGNrpVJPml1uVscr5rnz4wOr+Xpr91l6GjTCg0XdgLnEjZmY0HZ6dFP19nm7h/bFqT/hv7+ZDAGSDJGD7kLmjo8DknrORghorckvXLPgtyKM6nhx4q0BUMJjHbkfwQfq4Vy62EEBVi3e/m5rRm9sHasmCpdOQyywfQEx/S40q0i3ulv+Fj5bTErXX8TGxvc+IUOkcAULNajakkspHjrV6k4KDxf2ZYbOarmFYsHo0ICQ5ZA8Yox/7lwgjKwIBorTbnyQUidEHuMnKnDVTUJ+5Z+m9eM5lKr+UYw==bankingplays@openstack.casc', description: 'Public SSH key to be added to /root/.ssh/authorized_keys for accessing VMs created on openstack environment')
        string(name: 'SSH_KEY_PSI_KVM', defaultValue: 'ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQC8al5MbdxJTQGz5uchmGUeM/pkN8fTgYbaUkgEAgKivjSkp8Nv4wvEFZBgvPAbgk+Nj75pmbgp3j6XH/M0XKk7xHQpZCi3Xn9fmOACz8p8KXfhHSnJp1d1przstvPnlwWwD/KccfJuJlvoS1E74l0O6l8lGCGfj3cc9I1kjQizrFaAZo6QWHsF09eZoWGhwd/BNrh/aitCmxgGtsNXQZEUb3gJ2SJSnaFxbVq9NiJe4t//GbZ098i42BOc5iYApfO2NrUlB4GDBFenMbYLvwcPxe0Ce6fYunw+G/NVm12fNgZdeFAEBXRwA/vnx3p9kiPVoQxkn3DOBzbksu2cCmSUcykWRUlKCt2odWRyDQp0za1CY71DUKwk9Tb6r3SRNKd0F8pwjXDg8gyZuWNj9VPNwxowsbOsAp+ty0thbvqe+MWyzdppzZ6iYXm+iEf2Eh7t+qHnRyTBlEd8rouosMQLGCWdools/oJNL76pQAT44eG/8Kf5C1zAcPyCzl9WxrSH1gxWAqXUKnSqRzqSlUAZio/RJqEt1MKOqARc+cVBkkk8QQLSREEx8BmeNz0xRmM3z+NT832JrK0qOH6mVNQtfvTOh3D5Zzs9CAODq29PjJY+1nF3JbityjQ2DswPZS2H/Yxk3f7+NyHqXubsEqSWG+cQHAb5dS0I2LYiYz0aow==bankingplays@psikvm.casc', description: 'Public SSH key to be added to /root/.ssh/authorized_keys for accessing KVMs or VMs created on KVMs')
        string(name: 'SSH_KEY_PSI_RHV', defaultValue: 'ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQDC0Pi9n1b5CsoYJAOH5i0XP+ApPgAocGiUgaA89yEKj4t7YeA/CewJtpehmRVL1SJUPTTTFUYjFIpdEKjYVepVLZQTi5pyLisfwmip2li4SGG0rrK6OM5a+WyCZQCbwhNNp2tO/cZXlJdxJOd3M6zENuWo0i2EnXuyfEX0Rd7eq7D7l0ZqcDlRybI+NS6H1lf984NVlIbN6wvZS70mvxSjQ03/Cn7u/M4QG/JaqsMyYWDCiOW68B3clFv5c8KPQ+4KcaXmaSkDRp+RNHcFBASH2gClL07VL4Y25hKnTWrQLBoCz0ryjiYNGOTtD9Y9W7mL/DpcK3Yt2LiZ6mgGMpFeJyqPLr//pkx6vwZ2uHmb1P66HIv2uyEnXRD8ZDKLfvNS38/yDtie7Riddk9kr7yHgrnYWvOn/J+RlBF22IML37pCbgEWdI1HhtwLAk7v/JPqCGVIpkoYJXfuH/e+WTNihawasQTD8kCxyesfypK/RLoE9FqOdhwAQLtJE0y05Gqu8AL1okoezFqr1q5XXWbixDvW1PrkJH01Irxv3UNsvvTVEAJh5n4GCUN1LTsSaJ+8fDiWLwqCxGpq+ynDRpqkzbTZWfUsaLC1Ru7ipKfIpvO4sifREbEJD5oKfSxmiJJ2x7kopK/Cr9pOensGjrTHIApJRwwmrgJYIccXg3ufLQ==bankingplays@rhv.casc', description: 'Public SSH key to be added to /root/.ssh/authorized_keys for accessing VMs created on RHV environment')
        string(name: 'SSH_KEY_PSI_RHV', defaultValue: 'ssh-rsa AAAAB3NzaC1yc2EAAAABJQAAAgEApRla1WIiq6RiphfP75KVLVXzjGNOVPKJvQohNTmfHOk013EcVvTQJrYJ/larHwCin5FhSd4m3b/0ImaMkn/O/OzKMHFFnLBden9RM+o/FcAk8hmabyxey0A2cqAtMR0+BG1bmuVilc6Ws9o4+ctOiM0J04PyExZHutvtKQYxnlxgpzU3/QIPPeW0PVdcRnGLAh7oSuFm0ooyTD4NHX6c2Hds/ux9PVmFRWSPottt36WPGq8aiil3vTaHACj+w2/hlCGFr92idUEn50nS/BKBghjnwc5oUN/Jcq00DaBhFFWiRisQFRU4dKGNP3T9SmFQqKZJHvRGeKgdWYbddcD4rS44llGklI2Ixl8odMzohy2UmlnbIYwtlFnQIPoFwrIA5rPKXKcUU9w2Rt/KnjCBqeoujyog8pzCYR+qK4bl+XDxCexRv25L13dXmNz5bN2WovGpT4Am+MASGrF+HXGb0qkmgziiJxVK40mU8sLG0hmfrdJc6Ob0BGMu73HcLI5zsa7z3AYLzSEkbH8H7iBBlkXrijdQCHZIKHM+8YxpAGPVLSax16qwn7BX2WyAeejrJWA2crNqAIYNM3wxtTcb6EezkPkZQrzTxSQHwEhkt4F8vgWQSoY82gvH4+/yutdceqxP13tqHaLy0PkjonWx938NoAwJvusyxSt15ZFZurM= pratham-win10', description: 'Public SSH key to be added to /root/.ssh/authorized_keys for accessing VMs using any personal SSH key pair')

    }
    stages{
        stage('Checkout SCM'){
            steps{
                cleanWs()
                sh label: '', script: 'git config --global http.sslVerify false'
                checkout([$class: 'GitSCM', 
                branches: [[name: '*/main']], 
                extensions: [[$class: 'SubmoduleOption', 
                    disableSubmodules: false, 
                    parentCredentials: true, 
                    recursiveSubmodules: true, 
                    reference: '', 
                    trackingSubmodules: false]], 
                userRemoteConfigs: [[credentialsId: 'ashutoshjadhav8-git', url: 'https://github.com/pratham-m/ocp-automation.git']]])
                sleep 5
                sh label: '', script: 'git reset --hard'
            }
        }
        stage('VM Remote Setup'){
            steps{
                catchError(message: 'Remote setup failed!', buildResult:'UNSTABLE', stageResult: 'FAILURE'){
                    ansiColor('xterm'){
                        sh label: '', script: '''
                        #sed -i "/$VM_IP/d" /root/.ssh/known_hosts
                        #export FORCE_COLOR="true"
                        #./vm-remote-setup.sh $VM_IP $VM_USERNAME 
                        #$VM_PASSWORD
                        #./vm-remote-setup.sh
                        '''
                    }
                }
            }
        }
        stage('Pipeline Status'){
            steps{
                sh label: '', script: '#./pipeline-status.sh'
                echo "RESULT: ${currentBuild.result}"
                /*if(currentBuild.result != 'SUCCESS' && currentBuild.result != 'null'){
                    unstable('build is unstable')
                }*/
            }
        }
    }
}
