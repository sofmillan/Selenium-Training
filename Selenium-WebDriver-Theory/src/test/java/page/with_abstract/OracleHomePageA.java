package page.with_abstract;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.without_abstract.SearchResultsPage;

public class OracleHomePageA extends AbstractPage{
    private static final String HOMEPAGE_URL = "https://docs.oracle.com/en/";
    private WebDriver driver;

    @FindBy(id="search-bar-input")
    private WebElement searchInput;

    public OracleHomePageA(WebDriver webDriver) {
        super(webDriver);
    }


    public OracleHomePageA openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SearchResultsPageA searchForTerms(String term){
        searchInput.sendKeys(term);
        searchInput.sendKeys(Keys.RETURN);
        return new SearchResultsPageA(driver, term);
    }
}
