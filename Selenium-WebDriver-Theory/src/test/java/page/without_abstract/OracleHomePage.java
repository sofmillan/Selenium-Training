package page.without_abstract;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OracleHomePage {
    private static final String HOMEPAGE_URL = "https://docs.oracle.com/en/";
    private WebDriver driver;

    @FindBy(id="search-bar-input")
    private WebElement searchInput;

    public OracleHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OracleHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SearchResultsPage searchForTerms(String term){
        searchInput.sendKeys(term);
        searchInput.sendKeys(Keys.RETURN);
        return new SearchResultsPage(driver, term);
    }
}
