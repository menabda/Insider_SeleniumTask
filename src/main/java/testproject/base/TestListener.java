package testproject.base;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

import static testproject.base.BaseTest.driver;


public class TestListener implements ITestListener {

    private void attachPageSource(WebDriver driver) {
        String pageSource = driver.getPageSource();
        Allure.addAttachment("Page Source", "text/html", pageSource, ".html");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Allure.addAttachment(
                "Screenshot on Failure",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES))
        );
        attachPageSource(driver);
    }

}
