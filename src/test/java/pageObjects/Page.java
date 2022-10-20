package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
    public WebDriver ldriver;
    public Page(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(name = "q")
    @CacheLookup
    WebElement searchField;

    @FindBy(className = "search__title")
    @CacheLookup
    WebElement searchResult;

    @FindBy(xpath = "//*[contains(text(), 'Find locations')]")
    @CacheLookup
    WebElement findLocationsButton;

    @FindBy(css = ".input--xxlarge ")
    @CacheLookup
    WebElement searchSuburb;

    @FindBy(xpath = "//*[@class=\"location__title\" and contains(text(), \"Marrickville Service Centre\")]")
    @CacheLookup
    WebElement serviceLocation;

    public void setSearchText(String keyword) {
        searchField.sendKeys(keyword);
        searchField.sendKeys(Keys.ENTER);
    }

    public void validateSearchResults() {
        searchResult.isDisplayed();
    }

    public void clickFindLocations() {
        findLocationsButton.click();
    }

    public void setSearchSuburb(String keyword) {
        searchSuburb.sendKeys(keyword);
        searchSuburb.sendKeys(Keys.ENTER);
    }

}
