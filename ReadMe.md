
The given assignments have been successfully automated using Java and a few other libraries.
----------------------------------------------------------------------------------------------------------
Please follow below instructions to execute the test methods successfully.


Pre-Conditions to setup the project in your system
========================================
1. Java Programming language version 11 or above required
2. Eclipse or IntelliJ editors for execution is required
3. Make sure to have TestNG plugIn with your editor.
4. Make sure to have Maven plugIn with your editor.


Steps to setup the project in your editor
========================================
1. Clone the git repository
2. Make sure to have your project in your directory properly setup with Java compiler.
3. Make sure you have setup the Maven dependency configuration appropriately.
4. Make sure you have added the TestNG library appropriately into your editor's imported project.
5. Please do mvn clean, and force update Maven dependency to avoid any sort of configuration errors.


Steps to execute the test scenarios and to check report
============================================
1. Inside the directory "eGovAssignment", you will find a file by the name "Config.properties".
2. Open the file, and set the parameter and value like Serverendpoint = <url server url> // Instead of stg, you may also use any other in which you wnat to execute.
3.  Inside the directory "eGovAssignment", you will find a file by the name "testng.xml".
4. Right click on this file name from your editor's package explorer, and run as > TestNG (This feature is supported in any Java supported editors like Eclipse/ IntelliJ)
5. Wait for the completion of both the test scenarios execution (It might take a few minutes)
6. You will notice the new folder generated by the name "test-output", inside the same "eGovAssignment" directory.
7. Open the "test-output" folder, you will find a file "emailable-report.html". Open this file to check the results.


Additional Notes FYI
=================
1.  You may re-run the same file to check results again if you find failures by any reasons.
2. Every time you run the scripts, the  "test-output" folder gets updated with the latest test results and vanished with the older reports.
3. Since Maven dependencies are used inside pom.xml, there is no need to explicitly add any external dependencies.