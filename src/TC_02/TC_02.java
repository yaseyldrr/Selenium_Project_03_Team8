package TC_02;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC_02 extends BaseDriver {
    @Test
    public void Test1() {
        driver.get("https://shopdemo.fatfreeshop.com/?");
        MyFunc.bekle(2);

        driver.manage().window().maximize();

        WebElement demoEbook= driver.findElement(By.xpath("//*[@id='products']/div[1]/div/div[2]/a/div/div[2]/button"));
        demoEbook.click();
        MyFunc.bekle(1);

        driver.switchTo().frame(driver.findElement(By.className("EJIframeV3")));
        WebElement verificationBook = driver.findElement(By.xpath("//h5[text()='Demo eBook']"));
        Assert.assertTrue("Demo eBook sepete eklenemedi", verificationBook.getText().equals("Demo eBook"));
        MyFunc.bekle(1);

        WebElement payToBankCart= driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        payToBankCart.click();
        MyFunc.bekle(1);

        WebElement payButton= driver.findElement(By.xpath("//button[@class='Pay-Button']"));
        payButton.click();
        MyFunc.bekle(1);

        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        Assert.assertTrue(emailField.isDisplayed());
        MyFunc.bekle(1);

        WebElement nameField = driver.findElement(By.xpath("//input[@placeholder='Name On Card']"));
        Assert.assertTrue(nameField.isDisplayed());
        MyFunc.bekle(1);

        WebElement payBttn= driver.findElement(By.xpath("//button[@class='Pay-Button']"));
        payBttn.click();

        WebDriverWait bekle = new WebDriverWait(driver, Duration.ofSeconds(10));

        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#SnackBar>span")));
        WebElement invalids = driver.findElement(By.cssSelector("#SnackBar>span"));
        Assert.assertTrue("Geçersiz email",invalids.getText().contains("Invalid Email"));
        Assert.assertTrue("Geçersiz fatura adı",invalids.getText().contains("Invalid Billing Name"));

        BekleKapat();
    }
}
