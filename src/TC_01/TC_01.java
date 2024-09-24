package TC_01;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class TC_01 extends BaseDriver {
    @Test
    public void Test1() {
        driver.get("https://shopdemo.fatfreeshop.com/?");

        WebElement demoBook = driver.findElement(By.xpath("//*[@id='products']/div[1]/div/div[2]/a/div/div[2]/button"));
        demoBook.click();
        MyFunc.bekle(2);

        driver.switchTo().frame(driver.findElement(By.className("EJIframeV3")));
        WebElement assertBook = driver.findElement(By.xpath("//h5[text()='Demo eBook']"));
        Assert.assertTrue("Can't find in the cart", assertBook.getText().equals("Demo eBook"));
        MyFunc.bekle(2);

        WebElement promotionButton = driver.findElement(By.xpath("//*[@id='Overlay']/div/div[2]/div/div[1]/div[4]/button[2]"));
        promotionButton.click();
        MyFunc.bekle(2);

        WebElement promotionPlaceholder = driver.findElement(By.xpath("//*[@id='Overlay']/div/div[2]/div/div[1]/div[4]/div/input"));
        promotionPlaceholder.sendKeys("1111");

        WebElement addPromo = driver.findElement(By.xpath("//*[@id='Overlay']/div/div[2]/div/div[1]/div[4]/div/button"));
        addPromo.click();

        WebDriverWait bekle = new WebDriverWait(driver, Duration.ofSeconds(10));

        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='SnackBar']")));
        WebElement assertUnvalid = driver.findElement(By.xpath("//*[@id='SnackBar']/span"));
        Assert.assertTrue("Not unvalid assertion displayed",assertUnvalid.getText().equals("Invalid promo code"));

        BekleKapat();
    }
}
