This framework was created using a Behavior Driven Development model. It utilizes Maven as 
a project management tool as maven allows for testers and developers to utilize its pom.xml. 
This file allows for ease of use when adding, removing, and updating our jars, dependencies, 
as well as our libraries and plugins. It utilizes Selenium Webdriver, bonigarcia WebDriverManager,
surefire reports for easy access to emailable reports, as well as a few other 
useful dependencies. It utilizes Cucumber as well and all steps and test cases are written in the 
gherkin language which allows for easy communication and an understanding between all 
parties involved in the testing process. It is structured using a Page Object Model format as well
as well as its utilization of Singleton.

There are two commands utilized to run my test suites through the IDE terminal 
1. mvn test -Dcucumber.options="—tags @Regression"
2. mvn test -Dcucumber.options="—tags @Smoke"

These allow me to run my Smoke and Regression Suites.