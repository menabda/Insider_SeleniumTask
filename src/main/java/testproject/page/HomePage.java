package testproject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v137.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testproject.base.BaseTest;

public class HomePage {


    String url = "https://useinsider.com/";

    @FindBy (id = "wt-cli-accept-all-btn")
    WebElement acceptCookiesBtn;

    WebDriver driver;

    public HomePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void acceptCookies(){
        acceptCookiesBtn.click();
    }

    public void openPage(){
        driver.get(url);
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }

}
