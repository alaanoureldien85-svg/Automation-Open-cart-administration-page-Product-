package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase {

    @Test
    public void testAdminLogout() {
        AdminLogin.login("admin","123");
        AdminDashboard.clickLogout();

        Assert.assertTrue(AdminDashboard.isRedirectedToLoginPage(),
                "User was not redirected to login page.");

        Assert.assertTrue(AdminDashboard.getLoginPageHeading().contains("Please enter your login details"),
                "Login heading not found after logout.");
    }
}
