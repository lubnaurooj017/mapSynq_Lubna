# mapSynq_Lubna
This git repo is to automate the http://www.mapsynq.com/ website for testing purpose.

## Things which are configured in this automations:
>Tests are runnable from the command line
>Tests are run against a configurable host, we have used http://www.mapsynq.com as the default
>Tests are configured to run on a various browser 
>Tests are configurd to run on all OS combinations against a testing service
>Testing service credentials and all configuration settings are passed as environment variables
>Tests are configured to run in parallel


## maven commands to run the project through command line by passing arguments
`mvn clean test -Durl="http://www.mapsynq.com/" -Dbrowser="firefox" -DxmlFileName=testng.xml`


