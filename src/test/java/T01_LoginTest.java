import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class T01_LoginTest {
    public WebDriver driver ;
    @BeforeMethod
    public void BeforeLogin()
    {
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client");
    }
    @Test(description = "Login With valid Data")
    public void LoginTestCase()
    {
        //username ->hazemzain17@gmail.com
        //password ->Asd@1999
        String UserNameInput="hazemzain17@gmail.com";
        String PasswordInput="Asd@1999";
        new P01_LoginPage(driver).EnterUserName(UserNameInput)
                .EnterPassword(PasswordInput).ClickLoginButton();


        //WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/label[@class='m-2 blink_me']")));
        String ActualURL=driver.getCurrentUrl();
        String ExpectedUrl="https://rahulshettyacademy.com/client/dashboard/dash";
        SoftAssert soft=new SoftAssert();
        // Assert.assertEquals(ActualURL,ExpectedUrl);
        soft.assertEquals(ActualURL,ExpectedUrl);



    }
}
