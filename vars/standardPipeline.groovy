def call(body) {

        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()

        node {
           timestamps {
			stage("scm checkout") {                
				checkout scm
			}
		   }
		   
		   //def buildSteps = new BaseSteps(this, config)
           // def envName = "build"
          //  for (def name : buildSteps.stageNames()) {
          //      stage(name) {
          //          buildSteps.stepOfStage(name)()
         //       }
         //   }
        }
    }