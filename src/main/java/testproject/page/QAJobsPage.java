package testproject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class QAJobsPage {

    @FindBy(xpath = "//a[text()='See all QA jobs']")
    WebElement qaJobsBtn;
    @FindBy(id = "filter-by-location")
    WebElement locationsFilterSelect;
    @FindBy(id = "filter-by-department")
    WebElement departmentsFilterSelect;
    @FindBy(id = "select2-filter-by-location-container")
    WebElement locationPlaceholder;
    @FindBy(id = "select2-filter-by-department-container")
    WebElement departmentPlaceholder;
    @FindBy(className = "position-list-item-wrapper")
    List<WebElement> jobBlocks;




    WebDriver driver;
    String location = "Istanbul, Turkiye";
    String department = "Quality Assurance";

    public QAJobsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void navigateToQAJobsPage(){
        driver.get("https://useinsider.com/careers/quality-assurance/");
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }

    public void seeAllQAJobs(){
        qaJobsBtn.click();
    }

    public Boolean locationFilter() {
        Select select = new Select(locationsFilterSelect);
        select.selectByContainsVisibleText(location);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class,'position-list-item-wrapper')]")));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[contains(@class,'position-location')]"),location));
        return locationPlaceholder.getText().contains(location);
    }

    public Boolean departmentFilter() {
        Select select = new Select(departmentsFilterSelect);
        select.selectByContainsVisibleText(department);
        return departmentPlaceholder.getText().contains(department);
    }

    public int jobsAreVisible() {
        return jobBlocks.size();
    }




}
