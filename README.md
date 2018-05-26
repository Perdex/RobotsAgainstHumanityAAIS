# Furhat SDK alpha

> **Note**: this is an alpha release of the Furhat SDK. With this we mean that we known bugs and that we are expecting to release breaking changes for some time as we actively develop the SDK. Your feedback is immensely important for us to make the product better, thanks for helping us :-)

## Installation and running

* Import the Furhat SDK as a gradle project into IntelliJ IDEA.
* Once it has built, you can launch the SDK project by running the "run" task. Under Gradle -> Tasks -> application -> run.
* Or by running "gradlew run" . Using 'gradlew' uses the gradle wrapper we distribute.
* Double-check that Intellij IDEA is using 'Target jvm 1.8' ( File -> Settings -> Build, Execution, Deployment -> Compiler -> Kotlin Compiler)
* Start the development server, once running it will
  * serve the Web interface on http://localhost:8080 (port configurable in `ports.properties`) with default password **admin**
  * start receiving events on TCP broker port 1932

## Creating applications
* Applications (also called Skills) are created easiest from the web interface's Skills page. They will be put in the SDK's `skills`-directory and automatically refreshed and compiled by IntelliJ if you have imported the SDK as above. See more info on [application docs](https://docs.myfurhat.com/ng/applications/).
* Applications can be launched to run on remote Furhat robots (or SDK's) by providing the jvm argument -Dfurhatos.skills.brokeraddress=$ipaddress$ . In Intellij this is easiest done by editing the run configuration and adding that argument to the VM options.
## Feedback and contact
Please share feedback, bugs and ideas on our community forum [discuss.myfurhat.com](#) or directly by email on  [support@furhatrobotics.com](mailto:support@furhatrobotics.com)
