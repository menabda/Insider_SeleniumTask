package testproject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ViewRolePage {

    @FindBy(xpath = "//*[text()='View Role']")
    List<WebElement> viewRoleBtn;
    @FindBy(xpath = "//*[contains(@class,'posting-headline')]")
    WebElement jobHeadline;

    WebDriver driver;

    public ViewRolePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public Boolean viewRoleCheck(){
        String originalHandle = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        viewRoleBtn.getFirst().click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> allHandles = driver.getWindowHandles();
        for (String handle : allHandles) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOf(jobHeadline));
        return Objects.requireNonNull(driver.getCurrentUrl()).contains("https://jobs.lever.co/");
    }
}
