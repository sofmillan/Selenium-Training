package page.without_abstract;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage {
    private WebDriver webDriver;
    private String searchTerm;

   /* @FindBy(css = ".card-bg.card-small.oj-conveyorbelt-item")*/
    private List<WebElement> searchResults;

    public SearchResultsPage(WebDriver webDriver, String searchTerm) {
        this.webDriver = webDriver;
        this.searchTerm = searchTerm;
        PageFactory.initElements(webDriver, this);
    }

    public int countResultsNumberWithSearchTerm(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
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
