import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P01_LoginPage {
    private WebDriver driver;
    public P01_LoginPage(WebDriver UsedDriver)
    {
        this.driver=UsedDriver;
    }
    private final By UserName=By.id("userEmail");
    private final By Password=By.id("userPassword");
    private final By LoginButton=By.cssSelector("input[id='login']");
    public P01_LoginPage EnterUserName(String username)
    {
        driver.findElement(UserName).sendKeys(username);
        return  this;
    }
    public P01_LoginPage EnterPassword(String password)
    {
        driver.findElement(Password).sendKeys(password);
        return  this;
    }
    public P02_ShopingPage ClickLoginButton()
    {
        driver.findElement(LoginButton).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/label[@class='m-2 blink_me']")));
        return new  P02_ShopingPage(driver);
    }


}
