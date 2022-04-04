Feature: To validate the login Functionality 

Scenario: login with valid user id and valid password

Given the URL to open Ninja Home page
And navigate to login page
When enter the valid user id and password
And click on Login button
Then validate User should able to successfully login
