package tests;

import opencart_pages.AdminDashboardPage;
import opencart_pages.AdminLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class TestBase {
     WebDriver driver;
    AdminDashboardPage AdminDashboard;
    AdminLoginPage AdminLogin;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        AdminDashboard = new AdminDashboardPage(driver);
        AdminLogin = new AdminLoginPage(driver);
        AdminLogin.Navigate();    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
