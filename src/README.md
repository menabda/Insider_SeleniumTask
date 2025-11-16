# Selenium Automation Framework (Java, TestNG, POM)

This project is a Selenium automation framework built using **Java**, **TestNG**, and the **Page Object Model**.  
It includes Allure reporting, listeners for screenshots on failure, and a clean project structure for maintainability.

## Features
- Selenium WebDriver with TestNG
- Page Object Model (POM)
- PageFactory implementation for element initialization
- BaseTest with WebDriver setup
- Allure Reports integration
- Automatic screenshots on test failure

▶️ How to Run the Tests
Run the entire automation test suite using Maven:

mvn clean test

📊 Generate Allure Report

After running the tests, generate and open the Allure report:

allure serve

This will launch an interactive Allure dashboard locally. 