package com.sample.test.demo.tests;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import com.sample.test.demo.TestBase;
import utils.ElementFetch;

public class DemoTests extends TestBase {

    String pizzaTypeSelected = "Medium 8 Slices - 2 toppings";
    String pizzaTypeAlternateSelection = "Large 10 Slices - 2 toppings";
    ElementFetch elementFetch = new ElementFetch();

    /*author : Ankit Jain
        Date : 11/14/2021
        Desctiption : Happy Path Test Case to Place an Order on the Demo pizza website.
    */
    @Test
    public void bookAPizzaHappyPathEndtoEndScenario()  {
        // make selection from drop down
        makeASelectionFromDropDownList(pizzaTypeSelected,elementFetch.getWebElement("ID","pizza1Pizza"));
        makeASelectionFromDropDownList("Diced Mango",elementFetch.getWebElement("XPATH","//div[@id='pizza1']//select[@class='toppings1']"));
        makeASelectionFromDropDownList("Extra cheese",elementFetch.getWebElement("XPATH","//div[@id='pizza1']//select[@class='toppings2']"));
        elementFetch.getWebElement("ID","pizza1Qty").clear();
        elementFetch.getWebElement("ID","pizza1Qty").sendKeys("1");
        //enter customer's pickup information
        elementFetch.getWebElement("ID","name").sendKeys("Test Customer");
        elementFetch.getWebElement("ID","phone").sendKeys("8888888888");
        elementFetch.getWebElement("ID","phone").sendKeys("testemail@test.com");

        //make radio selection
        makeASelectionFromRadioButton(elementFetch.getWebElement("ID","ccpayment"));
        // place order
        elementFetch.getWebElement("ID","placeOrder");
        // check for dialog box and order confirmation
        if(elementFetch.getWebElement("ID","dialog").isDisplayed()){
            String dialogBoxContent = elementFetch.getWebElement("XPATH","//div[@id='dialog']/p").getText();
            // matching partial text here for Order confirmation message in dialog box. This
            // can be further enhanced by concatenating exact order value and pizza type in the
            // match string here.
            dialogBoxContent.contains("Thank you for your order! TOTAL:");
            System.out.println("Test passed as the Order for pizza type"+ pizzaTypeSelected + "has been placed successfully!!");
        } else{
            System.out.println("Test Failed as the Order for pizza type" + pizzaTypeSelected+ "could not be placed !!");
        }

    }
/*********************************************************************/
    /*author : Ankit Jain
        Date : 11/14/2021
        Desctiption : Error/ negative Scenario Test Case to Place an Order on the Demo pizza website and ensure failure.
    */
    @Test
    public void bookAPizzaErrorPathEndtoEndScenario() {
        // make selection from drop down
        makeASelectionFromDropDownList(pizzaTypeSelected, elementFetch.getWebElement("ID", "pizza1Pizza"));
        makeASelectionFromDropDownList("Diced Mango", elementFetch.getWebElement("XPATH", "//div[@id='pizza1']//select[@class='toppings1']"));
        makeASelectionFromDropDownList("Extra cheese", elementFetch.getWebElement("XPATH", "//div[@id='pizza1']//select[@class='toppings2']"));
        elementFetch.getWebElement("ID", "pizza1Qty").clear();
        elementFetch.getWebElement("ID", "pizza1Qty").sendKeys("1");

        //intentionally not filling up customer's pickup information

        //make radio selection
        makeASelectionFromRadioButton(elementFetch.getWebElement("ID", "ccpayment"));
        // place order
        elementFetch.getWebElement("ID", "placeOrder");
        // check for dialog box and order confirmation
        if (elementFetch.getWebElement("ID", "dialog").isDisplayed()) {
            String dialogBoxContent = elementFetch.getWebElement("XPATH", "//div[@id='dialog']/p").getText();
            // matching text here for missing name and phone number message in dialog box.
            if (dialogBoxContent.contains("Missing name\n" +
                    "Missing phone number")) {
                System.out.println("Test passed as the name and phone number warning message displayed as expected!!");
            } else {
                System.out.println("Test Failed as warning message did not show up as expected!!");
            }

        }

    }

/****************************************************************/
    /*author : Ankit Jain
       Date : 11/14/2021
       Another positive scenario :
       Desctiption : No pizza quantity entered scenario ,this should Place an Order without quqntity to ensure total should be reflected as zero.
   */
    @Test
    public void bookAPizzaNoQuantityScenarioToValidateOrderShouldTotalToZero()  {
        // make selection from drop down
        makeASelectionFromDropDownList(pizzaTypeSelected,elementFetch.getWebElement("ID","pizza1Pizza"));
        makeASelectionFromDropDownList("Diced Mango",elementFetch.getWebElement("XPATH","//div[@id='pizza1']//select[@class='toppings1']"));
        makeASelectionFromDropDownList("Extra cheese",elementFetch.getWebElement("XPATH","//div[@id='pizza1']//select[@class='toppings2']"));
        elementFetch.getWebElement("ID","pizza1Qty").clear();
        elementFetch.getWebElement("ID","pizza1Qty").sendKeys("");
        //enter customer's pickup information
        elementFetch.getWebElement("ID","name").sendKeys("Test Customer");
        elementFetch.getWebElement("ID","phone").sendKeys("8888888888");
        elementFetch.getWebElement("ID","phone").sendKeys("testemail@test.com");

        //make radio selection
        makeASelectionFromRadioButton(elementFetch.getWebElement("ID","ccpayment"));
        // place order
        elementFetch.getWebElement("ID","placeOrder");
        // check for dialog box and order confirmation
        if(elementFetch.getWebElement("ID","dialog").isDisplayed()){
            String dialogBoxContent = elementFetch.getWebElement("XPATH","//div[@id='dialog']/p").getText();
            // matching text from dialog box for total as Zero.
            dialogBoxContent.contains("Thank you for your order! TOTAL: 0");
            System.out.println("Test passed as the total is showing as Zero!!");
        } else{
            System.out.println("Test Failed as the Order total is not shown as Zero !!");
        }

    }

/*************************************************/
    /*author : Ankit Jain
        Date : 11/14/2021
        Desctiption : Switch pizza and toppings before Placing final Order on the Demo pizza website.
    */
    @Test
    public void switchOptionsForPizzaSelectionScenario()  {
        // make selection from drop down
        makeASelectionFromDropDownList(pizzaTypeSelected,elementFetch.getWebElement("ID","pizza1Pizza"));
        makeASelectionFromDropDownList("Diced Mango",elementFetch.getWebElement("XPATH","//div[@id='pizza1']//select[@class='toppings1']"));
        makeASelectionFromDropDownList("Extra cheese",elementFetch.getWebElement("XPATH","//div[@id='pizza1']//select[@class='toppings2']"));
        elementFetch.getWebElement("ID","pizza1Qty").clear();
        elementFetch.getWebElement("ID","pizza1Qty").sendKeys("1");
        //enter customer's pickup information
        elementFetch.getWebElement("ID","name").sendKeys("Test Customer");
        elementFetch.getWebElement("ID","phone").sendKeys("8888888888");
        elementFetch.getWebElement("ID","phone").sendKeys("testemail@test.com");
        // changing selectoin
        makeASelectionFromDropDownList(pizzaTypeAlternateSelection,elementFetch.getWebElement("ID","pizza1Pizza"));
        makeASelectionFromDropDownList("Olives",elementFetch.getWebElement("XPATH","//div[@id='pizza1']//select[@class='toppings1']"));

        //make radio selection
        makeASelectionFromRadioButton(elementFetch.getWebElement("ID","ccpayment"));
        // place order
        elementFetch.getWebElement("ID","placeOrder");
        // check for dialog box and order confirmation
        if(elementFetch.getWebElement("ID","dialog").isDisplayed()){
            String dialogBoxContent = elementFetch.getWebElement("XPATH","//div[@id='dialog']/p").getText();
            // matching partial text here for Order confirmation message in dialog box. This
            // can be further enhanced by concatenating exact order value and pizza type in the
            // match string here.
            dialogBoxContent.contains("Thank you for your order! TOTAL:");
            System.out.println("Test passed as the Order for pizza type"+ pizzaTypeAlternateSelection + "has been placed successfully!!");
        } else{
            System.out.println("Test Failed as the Order for pizza type" + pizzaTypeAlternateSelection+ "could not be placed !!");
        }

    }
}
