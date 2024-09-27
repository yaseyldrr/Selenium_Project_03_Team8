package TC_04;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TC_04 extends BaseDriver {
    @Test
    public void Test() {
        driver.get("https://shopdemo.fatfreeshop.com/?");

        MyFunc.bekle(2);

        WebElement demoBook = driver.findElement(By.xpath("(//button[@class='view_product'])[2]"));
        demoBook.click();
        MyFunc.bekle(2);

        driver.switchTo().frame(driver.findElement(By.className("EJIframeV3")));
        MyFunc.bekle(2);
        WebElement card = driver.findElement(By.xpath("//button[@data-option='CC']"));
        card.click();
        MyFunc.bekle(2);

        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        email.sendKeys("technostudyTeam8@gmail.com");

        WebElement confirmemail = driver.findElement(By.xpath("//input[@placeholder='Confirm Email']"));
        confirmemail.sendKeys("technostudyTeam8@gmail.com");

        WebElement kartIsmi = driver.findElement(By.xpath("//input[@placeholder='Name On Card']"));
        kartIsmi.sendKeys("Ronaldo");

        List<WebElement> optional = driver.findElements(By.xpath("//input[@placeholder='Optional']"));
        WebElement phone = optional.get(0);
        phone.sendKeys("+33169857885");

        WebElement company = optional.get(1);
        company.sendKeys("Realmadrid");


        WebElement textarea = driver.findElement(By.xpath("//textarea[@placeholder='Optional']"));
        textarea.sendKeys("Thank you for everything");


        driver.switchTo().frame(1);
        WebElement kartnumarasi = driver.findElement(By.xpath("//input[@placeholder='Kart numarası']"));
        kartnumarasi.sendKeys("4242 4242 4242 4242");

        WebElement date = driver.findElement(By.xpath("//input[@placeholder='AA / YY']"));
        date.sendKeys("12/24");


        WebElement cvc = driver.findElement(By.xpath("//input[@placeholder='CVC']"));
        cvc.sendKeys("000");

        driver.switchTo().parentFrame();
        WebElement pay = driver.findElement(By.xpath("//button[@class='Pay-Button']"));
        pay.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='confirme_text']")));
        WebElement confirmText = driver.findElement(By.xpath("//p[@class='confirme_text']"));

        Assert.assertTrue("Error", confirmText.getText().contains("confirmed"));

        BekleKapat();


    }
}
