package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testproject.base.BaseTest;
import testproject.page.ViewRolePage;

public class ViewRolePageTest extends BaseTest {

    @Test
    public void testViewRolePage(){
        ViewRolePage viewRolePage = new ViewRolePage(driver);
        Assert.assertTrue(viewRolePage.viewRoleCheck());
    }
}
