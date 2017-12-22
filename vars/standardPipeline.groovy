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

	
      	 stage("build") {
            def gradle_command = "gradle --quiet clean build";
            steps.echo gradle_command
            //在指定目录下执行命令  
            steps.dir('MyApplication/') {
			    steps.sh "chmod 755 gradlew"
                steps.sh "./gradlew assembleRelease"
			    //steps.sh gradle_command
		           // bat 'gradlew assembleDebug'
            }   
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