package page.with_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected WebDriver webDriver;
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
}
