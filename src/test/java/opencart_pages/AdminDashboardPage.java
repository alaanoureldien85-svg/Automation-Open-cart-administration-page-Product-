package opencart_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminDashboardPage {
    WebDriver driver;

    //Constructor
    public AdminDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By logoutLink = By.cssSelector(".fa-sign-out");
    By loginPageHeading = By.cssSelector(".card-header");

    // Actions
    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }

    public boolean isRedirectedToLoginPage() {
        return driver.getCurrentUrl().contains("route=common/login");
    }

    public String getLoginPageHeading() {
        return driver.findElement(loginPageHeading).getText();
    }
}
