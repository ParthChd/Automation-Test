# User Blog API Automation - Task 4


## Solution Highlight

In this project proposed test cases have been automated with below-mentioned features:

* REST assured library for testing and validating the Restful Web Services _as it removes a lot of boilerplate code and it
  supports BDD framework.


* Maven for build compilation & dependency management _as its easy to use and project setup is fast with best practices._


* Extent for reporting automation result _as it can generates interactive and detailed reports.


* Integration with CircleCI for implementing the continuous integration to release code rapidly and automate the build,test and deploy. 


## Overview

### Test Cases - Basic API Functionality 

These test cases are to verify the basic functionality of the API - like response code and content type

| Test Case          | Test if response code is 200 | Test if response content is 'application/xml' | 
|--------------------|------------------------------|-----------------------------------------------|
| Comments_Testcases | ✅                            | ✅                                             |  
| User_Testcases     | ✅                            | ✅                                             |                
| Posts_Testcases    | ✅                            | ✅                                             |                              


### Test Cases - UserBlogPostAndCommentsIntegrationTest

This is the complete E2E test to verify below steps:

* Inner class UserBlogUtil to store userId and set of post Id by user. 


* Search for list of users and filter out by username Samantha ->  store the userId in UserBlogUtil obj


* Search for all the posts by userId retrieved in above steps and store the post Id's in a set.


* Retrieve all the comments for each post and verify the email address is correct using apache-commons validator library.
    

## Requirements:

1. Check if maven is already installed on your machine(I have maven 5.8.6 on local):
>mvn --version

2. Skip this step if java 11 is already installed:
>brew install openjdk@11

3. Confirm java version is jdk11 with below command
>java -version

4. Any IDE such as Intellij,Eclipse etc.


5. Clone this repo on your local and once successfully imported run below command in project root path:
> mvn dependency:resolve


6. Right click on testng.xml and click Run '.../testng.xml'


7. Alternate you can run the test cases using 
> mvn clean verify


9. It will run the test suite parallel at class level for the test cases and generate the report at path '/testoutput/extentReport/UserBlogApiTestReport.html/'. I have also added the test report from last execution.


## Design Practices:

While designing the solution following design practices have been kept in mind:

     KISS  - Keep it simple Stupid 
     SOC   - Separation of Concerns 
     SOLID - SingleResponsibility



## Tools/Tech stack:
- REST-assured
- Maven
- Extent Reports
- Java
- IntelliJ
- Circle CI


### Note 
Integration with Circle CI is WIP, CI step is complete and currently upon doing a commit it would execute the test suite and depending upon the test result build would fail/pass. In future this can be integrated with AWS(or any other platform) to complete the continuous deployment step as well.
