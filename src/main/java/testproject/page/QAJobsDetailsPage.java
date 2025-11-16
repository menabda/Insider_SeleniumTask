package testproject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class QAJobsDetailsPage {

    @FindBy(xpath = "//*[contains(@class,'position-location')]")
    List<WebElement> positionLocation;
    @FindBy(xpath = "//*[contains(@class,'position-department')]")
    List<WebElement> positionDepartment;

    WebDriver driver;
    String location = "Istanbul, Turkiye";
    String department = "Quality Assurance";

    public QAJobsDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean checkAllElementsContainTextTraditional(List<WebElement> elements, String requiredText) {
        if (elements == null || elements.isEmpty()) {
            return false;
        }

        for (WebElement element : elements) {
            String elementText = element.getText().trim();

            if (!elementText.toLowerCase().contains(requiredText.toLowerCase())) {
                System.out.println("Element failed check: " + elementText);
                return false;
            }
        }

        return true;
    }

    public Boolean checkJobLocations(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[contains(@class,'position-location')]"),location));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'position-location')]")));
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[contains(@class,'position-department')]"),department));
        return checkAllElementsContainTextTraditional(positionLocation,location);
    }

    public Boolean checkJobDepartments(){
        return checkAllElementsContainTextTraditional(positionDepartment,department);
    }
}
