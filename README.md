# mapSynq_Lubna
This git repo is to automate the http://www.mapsynq.com/ website for testing purpose.

## Things which are configured in this automations:
- Tests are runnable from the command line
- Tests are run against a configurable host, we have used http://www.mapsynq.com as the default
- Tests are configured to run on a various browser eg Chrome, FireFox, Safari 
- Tests are configurd to run on all OS combinations against a testing service eg: windows, MacOS
- Testing service credentials and all configuration settings are passed as environment variables
- Tests are configured to run in parallel
- The automation runs via the UI within a browser
- Solution produces a detailed and clean report file under **target** folder insie the solution

## How to run this project
1. Clone this repo to your local directory **<LOCAL_WORKING_DIRECTORY>** : `git clone https://github.com/lubnaurooj017/mapSynq_Lubna.git`
2. Change the directory to <LOCAL_DIRECTORY>/lubna_work : `cd <LOCAL_WORKING_DIRECTORY>/lubna_work`
3. Follow the maven commands below to run (test) this project:

## maven commands to run the project through command line by passing arguments
`mvn clean test -Durl="http://www.mapsynq.com/" -Dbrowser="firefox" -DxmlFileName=testng.xml`

> *Some of important maven commands*:
```
mvn clean
mvn clean install
mvn pre-clean
mvn compile   
mvn package
```

