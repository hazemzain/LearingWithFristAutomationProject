import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Login {

    public WebDriver driver ;
    @BeforeMethod
    public void BeforeLogin()
    {
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @Test(description = "Login With valid Data")
    public void LoginTestCase()
    {
        //username ->hazemzain17@gmail.com
        //password ->Asd@1999

        driver.get("https://rahulshettyacademy.com/client");
        String LoginPageUrl=driver.getCurrentUrl();
        driver.findElement(By.id("userEmail")).sendKeys("hazemzain17@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Asd@1999");
        driver.findElement(By.cssSelector("input[id='login']")).click();
        ////div/label[@class='m-2 blink_me']
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/label[@class='m-2 blink_me']")));
        String ActualURL=driver.getCurrentUrl();
        String ExpectedUrl="https://rahulshettyacademy.com/client/dashboard/dash";
      SoftAssert soft=new SoftAssert();
       // Assert.assertEquals(ActualURL,ExpectedUrl);
        soft.assertEquals(ActualURL,ExpectedUrl);



    }
}
