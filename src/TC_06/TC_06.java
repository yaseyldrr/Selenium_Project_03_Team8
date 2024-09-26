package TC_06;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_06 extends BaseDriver {
    @Test
    public void Test1() {
        driver.get("https://shopdemo.e-junkie.com/ ");
        MyFunc.Bekle(1);

        WebElement loginElement = driver.findElement(By.xpath("//a[@href='/contact']"));
        loginElement.click();
        MyFunc.Bekle(1);

        WebElement name = driver.findElement(By.xpath("//input[@id='sender_name']"));
        name.sendKeys("technostudyteam8");

        WebElement email = driver.findElement(By.xpath("//input[@id='sender_email']"));
        email.sendKeys("technostudyteam8@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='sender_subject']"));
        password.sendKeys("Sepet");

        WebElement message = driver.findElement(By.xpath("//textarea[@id='sender_message']"));
        message.sendKeys("deneme mesaj");


        WebElement button = driver.findElement(By.id("send_message_button"));
        button.click();
        MyFunc.Bekle(1);

        wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertTrue(driver.switchTo().alert().getText().equals("Recaptcha didn't match"));



        BekleKapat();
    }
}
