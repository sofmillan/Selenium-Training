package page.with_abstract;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPageA extends AbstractPage{
    private WebDriver webDriver;
    private String searchTerm;

   /* @FindBy(css = ".card-bg.card-small.oj-conveyorbelt-item")*/
    private List<WebElement> searchResults;

    public SearchResultsPageA(WebDriver webDriver, String searchTerm) {
        super(webDriver);
        this.searchTerm = searchTerm;

    }

    public int countResultsNumberWithSearchTerm(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
/*
        List<WebElement> searchResults = webDriver.findElements(By.cssSelector(".card-bg.card-small.oj-conveyorbelt-item"));
*/
/*
        List<WebElement> searchResults = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector()));
*/
        searchResults = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".card-bg.card-small.oj-conveyorbelt-item")));
        return searchResults.size();
    }
}
