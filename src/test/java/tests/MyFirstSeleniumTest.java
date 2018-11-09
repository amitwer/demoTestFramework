package tests;

import businessflows.SearchFlows;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium.WebDriverFactory;

public class MyFirstSeleniumTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        this.driver = WebDriverFactory.getChromeDriver();
    }

    @AfterClass
    public void teardown() {
        this.driver.quit();
    }

    @Test
    public void TestGoogleSearch() throws InterruptedException {

        int numOfResults = SearchFlows.search(driver);
        Assertions.assertThat(numOfResults).as("Number of search results").isGreaterThan(0);

        Thread.sleep(4000);
    }




}
