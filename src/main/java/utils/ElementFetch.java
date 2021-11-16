package utils;

import com.sample.test.demo.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementFetch {
    public WebElement getWebElement(String identifierType, String identifierValue) {
        switch (identifierType) {
            case "ID":
                return TestBase.driver.findElement(By.id(identifierValue));
            case "XPATH":
                return TestBase.driver.findElement(By.xpath(identifierValue));
            default:
                return null;

        }

    }

}

