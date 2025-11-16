package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testproject.base.BaseTest;
import testproject.page.CareersPage;

public class CareersPageTest extends BaseTest {

    @Test
    public void testCareersPage(){
        CareersPage careersPage = new CareersPage(driver);
        careersPage.navigateToCareersPage();
        Assert.assertEquals(careersPage.getCurrentURL(),"https://useinsider.com/careers/");
        Assert.assertTrue(careersPage.careerLocationElementVisibility());
        Assert.assertTrue(careersPage.careerTeamElementVisibility());
        Assert.assertTrue(careersPage.lifeAtInsiderElementVisibility());
    }


}
