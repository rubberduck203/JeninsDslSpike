job('cpp_dev_daily') {
    description 'Triggers the Jenkinsfile pipeline for cpp-daily:develop on a daily schedule.\n' +
            '5:05 am\n' +
            '12:05 noon'

    triggers {
        timerTrigger {
            spec('05 05,12 * * *')
        }
    }

    steps {
        downstreamParameterized {

            trigger('cpp-daily/develop') {
                block {

                    buildStepFailure('FAILURE')
                    unstable('UNSTABLE')
                    failure('FAILURE')

                }
            }
        }
    }
}