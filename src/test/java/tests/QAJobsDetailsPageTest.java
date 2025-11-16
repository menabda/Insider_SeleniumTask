package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testproject.base.BaseTest;
import testproject.page.QAJobsDetailsPage;

public class QAJobsDetailsPageTest extends BaseTest {

    @Test
    public void testQAJobsDetails(){
        QAJobsDetailsPage qaJobsDetailsPage = new QAJobsDetailsPage(driver);
        Assert.assertTrue(qaJobsDetailsPage.checkJobLocations());
        Assert.assertTrue(qaJobsDetailsPage.checkJobDepartments());
    }
}
