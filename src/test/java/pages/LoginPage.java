package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private By userId = By.id("mobileNo");
    private By password = By.id("et_password");
    private By login_Button = By.id("btn_mlogin");
    private By existingUser_login = By.id("btn_mlogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage invalidLogin() {
        waitForVisibilityOf(existingUser_login);
        driver.findElement(existingUser_login).click();
        driver.findElement(userId).clear();
        driver.findElement(userId).sendKeys("someone@testvagrant.com");
        driver.findElement(password).sendKeys("testvagrant123");
        driver.findElement(login_Button).click();
        Assert.assertTrue(driver.findElement(By.id("pageLevelError")).getText().equalsIgnoreCase("Account does not exist"));
        return new LoginPage(driver);
    }
}
