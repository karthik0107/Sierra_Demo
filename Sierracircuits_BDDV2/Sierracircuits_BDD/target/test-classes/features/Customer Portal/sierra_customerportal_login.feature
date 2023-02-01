Feature: Customer Portal  User Login 

@SmokeTest
Scenario: Login with valid credentials 
Given User navigate to customer portal Login page
When User enters valid email address for customer portal "scanewuser55@gmail.com"
And Ueer enters valid password for customer portal "Welcome*123"
And Clicks on Login button 
Then Customer Portal user should login successfully
And the user Navigate to Design RFQ Page
And Verify the Design RFQ Page get opend 