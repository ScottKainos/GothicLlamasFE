# GothicLlamasFE
Team  GothicLLamas front-end repo.
---
1. git clone https://github.com/ScottKainos/GothicLlamasFE.git to your local machine.
2. git clone https://github.com/ScottKainos/GothicLLamasBE.git to your local machine, cd  into the directoryand follow the README instructions. After step 3, return to the front end directory.
3. To run the front-end, and generally the application, type npm start into your terminal when inside the front-end directory.
4. Navigate to localhost:7999/ to begin the application.

# Testing
---
To run the unit tests for the front-end, in the front-end directory run the command npm test

#Selenium testing
---
1. To run the selenium tests both the front-end and the back-end of the program must be running
2. Open the front end of the application with intellij
3. Ensure that the selenium test folder is being treated as a maven application. Do this by right clicking the pom.xml and select 'test as maven application'
4. Find the testng.xml file in selenium_test/src/test/testng.xml right click it and select 'run'
