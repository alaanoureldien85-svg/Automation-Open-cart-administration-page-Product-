package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminLoginTests extends TestBase {

    @Test
    public void testValidAdminLogin() {
        AdminLogin.login("admin","123");

        String heading = AdminLogin.getDashboardHeading();
        Assert.assertTrue(heading.contains("Dashboard"), "Admin dashboard not displayed after login.");

    }

    @Test
    public void testInvalidAdminLogin() {
        AdminLogin.login("wronguser","wrongpass");

        String warning = AdminLogin.getWarningMessage();
        Assert.assertTrue(warning.contains("No match for Username and/or Password."), "Expected warning not displayed for invalid login."
        );
    }

    @Test
    public void testInvalidUsernameValidPassword() {
        AdminLogin.login("wronguser","123");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-danger")));

        String warning = driver.findElement(By.cssSelector(".alert-danger")).getText();
        Assert.assertTrue(warning.contains("No match for Username and/or Password."),
                "Expected warning not displayed for invalid username + valid password.");
    }

    @Test
    public void testValidUsernameInvalidPassword() {
        AdminLogin.login("admin","wrongpass");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-danger")));

        String warning = driver.findElement(By.cssSelector(".alert-danger")).getText();
        Assert.assertTrue(warning.contains("No match for Username and/or Password."),
                "Expected warning not displayed for valid username + invalid password.");
    }
}
