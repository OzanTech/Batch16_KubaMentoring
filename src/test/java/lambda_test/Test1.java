package lambda_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Test1 {
    @Test
    public void TC_01(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/");


        WebElement link= driver.findElement(By.xpath("//a[.='Input Form Submit']"));
        link.click();

        WebElement name= driver.findElement(By.cssSelector("#name"));
        name.sendKeys("Ozan Cifci");

        WebElement email= driver.findElement(By.cssSelector("#inputEmail4"));
        email.sendKeys("xyz@yahoo.com");

        WebElement passWord= driver.findElement(By.cssSelector("#inputPassword4"));
        passWord.sendKeys("123456");

        WebElement company=driver.findElement(By.cssSelector("#company"));
        company.sendKeys("Premium Properties");

        WebElement website=driver.findElement(By.cssSelector("#websitename"));
        website.sendKeys("www.ozan.com");

        WebElement city=driver.findElement(By.cssSelector("#inputCity"));
        city.sendKeys("Orlando");

        WebElement address= driver.findElement(By.cssSelector("#inputAddress1"));
        address.sendKeys("7521 W Sand Lake rd");

        WebElement address2=driver.findElement(By.cssSelector("#inputAddress2"));
        address2.sendKeys("Dr. Phillips");

        WebElement state=driver.findElement(By.cssSelector("#inputState"));
        state.sendKeys("FL");

        WebElement zipCode=driver.findElement(By.cssSelector("#inputZip"));
        zipCode.sendKeys("32819");

        List<WebElement> allButtons=driver.findElements(By.cssSelector("//button[@type='submit']"));

        for (int i = 0; i < allButtons.size(); i++) {
            if (allButtons.get(i).getText().equalsIgnoreCase("submit")){
                allButtons.get(i).click();
            }
        }

        List<WebElement> allMessages=driver.findElements(By.xpath("//p"));
        for (int i = 0; i < allMessages.size(); i++) {
            if (allMessages.get(i).getText().contains("Thanks")) {
                System.out.println(allMessages.get(i).getText());
                Assert.assertTrue(allMessages.get(i).isDisplayed());

            }
        }
            System.out.println("this one for github");




    }
}
