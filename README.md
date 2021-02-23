# **Friday Web Automation**
# **Selenium Testng Project**
UI test automation project for "friday.de". Added the required dependencies for TestNG and Selenium to the POM file. TestNG used for starting my tests and for assertions, Selenium Webdriver for browser automation.  The JAVA Project used Chrome Browser.
Maven is used as build tool. The Page-Object-Pattern is used straight away to specify elements.
It has a package for  utilities where all drivers and utilities are stored. The necessary information is added in configuration.properties file and can be reached that info with the help of configuration.readers class.
Driver class is designed with Singleton Design Pattern. HTML reports are generated with ExtentReports.
# **Prerequisites**
-JDK8 installed
# **Features:**

-full control by annotations
<br>-page object pattern ready
<br>-take screenshot on test failure
<br>-highlight clicked elements
<br>-pretty and highly readable console output
<br>-centralized project config
<br>-assertions, waits and test extensions
<br>-assertions with selenium specific and type safe matchers
<br>-waiting functions
<br>-meaningful test result report
# **Take Screenshots**
On test failures screenshots will automatically be taken and stored under test-output/Screenshot. The screenshot files will be named with a combination of the class name and the test method name.

 
