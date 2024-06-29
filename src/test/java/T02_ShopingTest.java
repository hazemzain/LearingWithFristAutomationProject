import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class T02_ShopingTest {
    public WebDriver driver ;
    @BeforeMethod
    public void BeforeLogin()
    {
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client");
    }
    @Test(description = "Login With valid Data")
    public void SignOutTestCase()
    {
        //username ->hazemzain17@gmail.com
        //password ->Asd@1999
        String UserNameInput="hazemzain17@gmail.com";
        String PasswordInput="Asd@1999";
        new P01_LoginPage(driver).EnterUserName(UserNameInput)
                .EnterPassword(PasswordInput)
                .ClickLoginButton().ClickSignOutButton();

        String ActualURL=driver.getCurrentUrl();
        String ExpectedUrl="https://rahulshettyacademy.com/client/dashboard/dash";
        SoftAssert soft=new SoftAssert();
        // Assert.assertEquals(ActualURL,ExpectedUrl);
        soft.assertNotEquals(ActualURL,ExpectedUrl);



    }
    @Test
    public void ChooseProductTestCase()
    {
        String UserNameInput="hazemzain17@gmail.com";
        String PasswordInput="Asd@1999";
        int ExpectedNumberOfProductAdded=0;
        new P01_LoginPage(driver).EnterUserName(UserNameInput)
                .EnterPassword(PasswordInput)
                .ClickLoginButton().AddProductInTheCard("ZARA COAT 3").AddProductInTheCard("ADIDAS ORIGINAL");

        String ActualNumberOfProductAdded = new P02_ShopingPage(driver).ActualNumberOfProductAddToCardInPage();
        int ActualNumberOfProduct=Integer.parseInt(ActualNumberOfProductAdded);
        Assert.assertEquals(ActualNumberOfProduct,2);

    }
}
