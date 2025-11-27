package opencart_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage {
    WebDriver driver;

    //Constructors
    public AdminLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By usernameField = By.id("input-username");
    By passwordField = By.id("input-password");
    By loginButton = By.cssSelector("button[type='submit']");
    By dashboardHeading = By.cssSelector("#content h1");
    By warningMessage = By.cssSelector(".alert-danger");

    // Actions
    public void login (String username, String password){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getDashboardHeading() {
        return driver.findElement(dashboardHeading).getText();
    }

    public String getWarningMessage() {
        return driver.findElement(warningMessage).getText();
    }
    public void Navigate() {
        driver.get("http://localhost/opencartProject/admin2/index.php?route=common/login");
    }
}
