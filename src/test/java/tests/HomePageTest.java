package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testproject.base.BaseTest;
import testproject.page.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void testHomePage(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.acceptCookies();
        Assert.assertEquals(homePage.getURL(),"https://useinsider.com/");
    }
}
