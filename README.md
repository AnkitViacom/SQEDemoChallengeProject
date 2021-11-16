## Demo Challenge

#### Instructions
1. Complete the project setup as listed below
2. Complete the Excerise
3. Email a synopsis of your work and the link to your git repo containing the completed exercise to: sqedemonstrationchallenge@nbcuni.com


#### Expectations
We will be evaluating
1. Naming conventions
2. Code readability
3. Code encapsulation
4. Code structure and organization
5. Quality of test cases
6. Variety  of testing types (examples: boundary, happy path, negative, etc) 


#### Technologies
1. Java
2. Selenium
3. TestNG
4. Any other technologies you see fit.
5. Please do not use a BDD framework.

#### Project Setup
1. Clone this project to your git account in a public repo
2. Setup the project in your IDE
3. Open the index.html file from src/test/resource/files in a browser
4. Copy the url from the browser and update the url value in src/test/resource/config.properties to be the copied url.
5. In src/test/resources update the config.properties file platform for your OS.
6. From command line run mvn clean install -U -DskipTests
7. Make sure you can run the DemoTest and chrome launches.  You may need to update the chromedriver in /src/test/resources/chromedriver/ to the version that works with your browser
   https://chromedriver.chromium.org/


#### Exercise
1. Use the site at the index.html
2. There are helper locators provided for you in the src/test/resource/files/locators.txt file.
3. In the Test Cases section below:
  - List all of the test cases you think are necessary to test the sample page
  - Note any defects or issues observed
4. Code up a few examples of:
  - At least one happy path case placing an order
  - At least one error case
5. When complete please check your code into your public git repo

#### Test Cases

#### Test Cases

1. Need to test end to end flow for pizza selection ,toppings selection, check the total cost amount , writing customer details in relevant text boxes, radio
   button selection for payment option and finally placing order.
2. To verify that switching between pizza and topping selection is possible in real time.
3. To verify cost calulated is as per the selection made.
4. To verify upper limit on number of pizza being ordered. for example a usual restaurant would not allow more than 20 pizzas to be ordered in one go. This field would need 
   extensive testing it allows numbers with a set upper limit.
5. To verify no negative integer values should be accepted as a valid input for number of pizzas.
6. To verify no alteration possible to cost field and it should be auto-populated every time a pizza selection is made. customer must not be able to make any modificatoin to this 
   field values.
7. To ensure the name text field only allows alphabets and no numeric or special chaaracters must be allowed. Should have a predefined length restriction on this field.
8. To verify Email field should accept alphbets and numeric digits but there should a mandate of having character @ in the information entered here. If no @ character is present
   than the email id must be counted as invalid and should throw error.Should have a predefined length restriction on this field.
9. phone number field should only accept numeric values and no alphabets or special characters should be allowed here. also its length should be 10 digits only.
10. not more than one mode of payment selection should be allowed at the same time. one radio button of payment mode should disable selction of other one.
11. after selection of payment mode it must ask payment details , that section must be designed before order confirmation. 
12 .Functionality of reset button should be verified, when clicked it should reset every field on page to default values.
13. No same topping selection should be allowed in both the topping dropdown at the same time. it should omit the topping selection from other drop down when already 
    selected in one of the dropdown.

