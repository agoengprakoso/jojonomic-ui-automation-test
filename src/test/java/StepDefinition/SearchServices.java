package StepDefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.Page;

import java.security.Key;

public class SearchServices {
    public WebDriver driver;
    public Page page;

    @Given("I Open browser")
    public void iOpenBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver");
        driver = new ChromeDriver();
        page = new Page(driver);
        driver.manage().window().maximize();
    }

    @And("Open website NSW")
    public void openWebsiteGoogle() throws InterruptedException{
        driver.get("https://www.service.nsw.gov.au/");
        Thread.sleep(1000);
    }

    @When("^I search \"([^\"]*)\"$")
    public void iSearch(String searchValue) throws InterruptedException {
        page.setSearchText(searchValue);
        Thread.sleep(2000);
        page.validateSearchResults();
    }

    @Then("Click on Find locations button")
    public void clickOnButton() {
        page.clickFindLocations();
    }

    @And("^I search suburb \"([^\"]*)\"$")
    public void iSearchSuburb(String searchSuburb) throws InterruptedException {
        Thread.sleep(2000);
        page.setSearchSuburb(searchSuburb);
        Thread.sleep(2000);
    }

    @And("I close browser")
    public void iCloseBrowser() {
        driver.close();
    }
}
