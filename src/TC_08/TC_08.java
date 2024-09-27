package TC_08;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TC_08 extends BaseDriver {
    @Test
    public void Test1() throws InterruptedException {
        driver.get("https://www.e-junkie.com/");

        WebElement videoButton = driver.findElement(By.xpath("//*[@id='top']/main/div[1]/div[1]/div[1]/div/div/a[1]"));
        videoButton.click();
        MyFunc.bekle(2);

        Assert.assertTrue("Can't load the page", driver.getCurrentUrl().equals("https://www.e-junkie.com/"));

        MyFunc.bekle(5);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.elementFromPoint(200, 100).click();");

        WebElement iframe = driver.findElement(By.cssSelector("iframe"));
        driver.switchTo().frame(iframe);

        WebElement playButton = driver.findElement(By.cssSelector(".ytp-large-play-button"));
        playButton.click();

        Thread.sleep(10000);

        driver.quit();
    }
}
