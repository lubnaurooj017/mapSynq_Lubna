## mapSynq_Lubna
This git repo is to automate the http://www.mapsynq.com/ website for testing purpose.

## Tools used
- selenium
- eclipse
- TestNG
- maven

## Language code is written
- java

## Frameworks followed
- POM
- DOM

## Things which are implemented/configured in this automations:
- [x] Tests are runnable from the command line
- [x] Tests are run against a configurable host, we have used http://www.mapsynq.com as the default
- [x] Tests are configured to run on a various browser eg Chrome, FireFox, Safari 
- [x] Tests are configurd to run on all OS combinations against a testing service eg: windows, MacOS
- [x] Testing service credentials and all configuration settings are passed as environment variables
- [x] Tests are configured to run in parallel
- [x] The automation runs via the UI within a browser
- [x] Solution produces a detailed and clean report file under **target** folder insie the solution

## How to run this project
1. Clone this repo to your local directory **<LOCAL_WORKING_DIRECTORY>** : 
`git clone https://github.com/lubnaurooj017/mapSynq_Lubna.git`
2. Change the directory to <LOCAL_DIRECTORY>/lubna_work : `cd <LOCAL_WORKING_DIRECTORY>/lubna_work`
3. Follow the maven commands below to run (test) this project:

## maven command to run the project through command line by passing arguments
> chrome
`mvn clean test -Durl="http://www.mapsynq.com/" -Dbrowser="chrome" -DxmlFileName=testng.xml`

> Firefox
`mvn clean test -Durl="http://www.mapsynq.com/" -Dbrowser="firefox" -DxmlFileName=testng.xml`

> Safari
`mvn clean test -Durl="http://www.mapsynq.com/" -Dbrowser="safari" -DxmlFileName=testng.xml`

> *Some of important maven commands*:
```
mvn clean
mvn clean install
mvn pre-clean
mvn compile   
mvn package
```
## Test Cases reports captured ?
- [x] YES
## Location of test report captured:
- Go to <LOCAL_WORKING_DIRECTORY>/lubna_work/target/surefire-reports/
- Then click index.html present inside
- Things you should be able to see:
      ```
      testng.xml
      1 test
      0 groups
      Times
      Reporter output
      Ignored methods
      Chronological view
      ```

## Test Cases **SCREENSHOTS** captured ?
- [x] YES

## Location of screenshots captured
> <LOCAL_WORKING_DIRECTORY>/lubna_work/ScreenShots/

## Test Data provided ?
- [x] YES
## Location of Test Data file
> <LOCAL_WORKING_DIRECTORY>/lubna_work/testdata/direction_test_data.json

## firefox gecko driver and chrome driver location
> <LOCAL_WORKING_DIRECTORY>/lubna_work/src/driverfile

## Project structure
### root/Packages/class/:
- src/main/java
  - mapSynqPages
    - directionClass.java
    - liveClass.java
    - personalClass.java
- src/test/java
  - mapSynqTest
    - mapSynqLiveTestCaseClass.java
    - mapSynqTestClass.java
- JRE System Library
- Maven Dependencies
- Screenshots
- src
- target
- test-output
- testdata
- pom.xml
- testng.xml

## Test Cases:


