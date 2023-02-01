Feature: OutLook Portal  User Login 

@SmokeTest
Scenario: Login with valid credentials 
Given User navigate to outlook portal Login page
When User enters valid email address for login outlook portal "sierrausercci.live@outlook.com"
And Clicks on Next button 
And Ueer enters valid password for outlook "Welcome*1234"
And Clicks on Login button for outlook 
And Clicks on Yes button 
And Clicks on Menu button 
And Clicks on Outlook 
Then User should login successfully
And Clicks on Search 
And Search the Workorder Id "385671038"
And Clicks on Workorder Id
