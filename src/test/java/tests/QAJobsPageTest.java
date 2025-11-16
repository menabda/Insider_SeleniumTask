package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testproject.base.BaseTest;
import testproject.page.QAJobsPage;

public class QAJobsPageTest extends BaseTest {

    @Test
    public void testQAJobsPage() {
        QAJobsPage qaJobsPage = new QAJobsPage(driver);
        qaJobsPage.navigateToQAJobsPage();
        Assert.assertEquals(qaJobsPage.getURL(),"https://useinsider.com/careers/quality-assurance/");
        qaJobsPage.seeAllQAJobs();
        Assert.assertEquals(qaJobsPage.getURL(),"https://useinsider.com/careers/open-positions/?department=qualityassurance");
        Assert.assertTrue(qaJobsPage.locationFilter());
        Assert.assertTrue(qaJobsPage.departmentFilter());
        Assert.assertNotEquals(qaJobsPage.jobsAreVisible(),0);
    }
}
