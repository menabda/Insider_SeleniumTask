package testproject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CareersPage{

    @FindBy(xpath = "//*[@id='navbarDropdownMenuLink'][contains(text(),'Company')]")
    WebElement companyDropDownElement;

    @FindBy(xpath = "//div[@id='navbarNavDropdown']//a[text()='Careers']")
    WebElement careersDropDownElement;

    @FindBy(id = "career-our-location")
    List<WebElement> careerLocationSection;

    @FindBy(id = "career-find-our-calling")
    List<WebElement> careerTeamSection;

    @FindBy(xpath = "//section[@data-id='a8e7b90']") //alternative xpath: //h2[text()='Life at Insider']/ancestor::section
    List<WebElement> lifeAtInsiderSection;

    WebDriver driver;

    public CareersPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToCareersPage(){
        companyDropDownElement.click();
        careersDropDownElement.click();
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public Boolean careerLocationElementVisibility(){
        return !careerLocationSection.isEmpty();
    }

    public Boolean careerTeamElementVisibility(){
        return !careerTeamSection.isEmpty();
    }

    public Boolean lifeAtInsiderElementVisibility(){
        return !lifeAtInsiderSection.isEmpty();
    }



}
