package com.sample.test.demo;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class TestBase {

    protected Configuration config;
    public static WebDriver driver;
    protected String url;

    @BeforeClass(alwaysRun = true)
    public void init() throws Throwable {
        config = new Configuration();
        url = config.getUrl();
        initializelDriver();
        navigateToSite();
    }

    private void navigateToSite() {
        driver.get(url);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        try {
            driver.quit();

        } catch (Exception e) {
        }
    }

    private void initializelDriver() {
        if (config.getBrowser().equalsIgnoreCase("chrome")) {
            if (config.getPlatform().equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/mac/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver",
                        "src/test/resources/chromedriver/windows/chromedriver.exe");
            }
            ChromeOptions capability = new ChromeOptions();
            capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
            driver = new ChromeDriver(capability);
        }
        else {
            fail("Unsupported bfrowser " + config.getBrowser());
        }
       
    }

    // Method to make valid selection on given dropdown
    // parameters used : dropdown and the selection value
    public void makeASelectionFromDropDownList(String selectedValue, WebElement ele){
        Select select = new Select(ele);
        select.selectByValue(selectedValue);
    }
    // Method to make valid radio button selection
    // parameters used : webelement of radio button type.
    public void makeASelectionFromRadioButton(WebElement ele)
    {
        ele.click();
    }

}
