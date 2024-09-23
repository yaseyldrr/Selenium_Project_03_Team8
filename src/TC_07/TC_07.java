package TC_07;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class TC_07 extends BaseDriver {
    @Test
    public void MainPageUrlVerification(){
        driver.get("https://shopdemo.e-junkie.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement e_commerceButton = driver.findElement(By.xpath("//a[contains(text(),'E-commerce')]"));
        e_commerceButton.click();

        WebElement e_junkieLogo = driver.findElement(By.xpath("//a[@href='/']"));
        e_junkieLogo.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.e-junkie.com/";
        Assert.assertEquals(actualUrl,expectedUrl);

        BekleKapat();
    }

}
