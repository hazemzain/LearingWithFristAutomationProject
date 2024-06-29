import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class P02_ShopingPage {
    private final WebDriver driver;
    private final By SignOutButton= By.xpath("//li[5]//button[@class='btn btn-custom']");
    private final By AllProductsInThePage=By.xpath("//div[@class='card-body']/h5");
    private final By AllProductsAddCardButtonInThePage=By.xpath("//div/button[@class='btn w-10 rounded']");
    private final By ActualNumberOfProductsAddToCard=By.xpath("//button/label");
    private final By ProductAddSuccessfully=By.xpath("//div/div[@id='toast-container']");
    private final By PageWaiting=By.xpath("//ngx-spinner");
    private static int CountNumberOfProducts=0;
    public P02_ShopingPage(WebDriver driver) {
        this.driver=driver;
    }
    public String ActualNumberOfProductAddToCardInPage()
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ActualNumberOfProductsAddToCard));

        return driver.findElement(ActualNumberOfProductsAddToCard).getText();
    }
    public int ExpectedNumberOfProductAddToCardInPage()
    {


        return CountNumberOfProducts;

    }
    public P02_ShopingPage AddProductInTheCard(String NameOfProduct)
    {
       List<WebElement>Products= driver.findElements(AllProductsInThePage);
       CountNumberOfProducts++;

       //Check That All Product In Pages Is Add to List
       for(int i=0;i<Products.size();i++)
       {

           String p=Products.get(i).getText();
           if(p.equals(NameOfProduct))
           {
               System.out.println(Products.get(i).getText());


           driver.findElements(AllProductsAddCardButtonInThePage).get(i).click();
           WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
           wait.until(ExpectedConditions.invisibilityOfElementLocated(PageWaiting));
           }
       }




        return new P02_ShopingPage(driver);
    }


    public P01_LoginPage ClickSignOutButton()
    {
        driver.findElement(SignOutButton).click();
        return new P01_LoginPage(driver);



    }
}
