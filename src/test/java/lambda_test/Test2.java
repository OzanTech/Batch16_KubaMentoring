package lambda_test;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.TreeMap;

public class Test2 {
    /*

    print out names and emails as a key -value pair
    use map interface and list them in ascending order
     */

    @Test
    public void ascendingOrder(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/");

        WebElement tablePagination= driver.findElement(By.xpath("//a[contains(.,'Table Pagination')]"));
        tablePagination.click();

        WebElement rows= driver.findElement(By.cssSelector("#maxRows"));
        BrowserUtils.selectBy(rows,"0","index");

        List<WebElement> allNames=driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allEmails=driver.findElements(By.xpath("//tr//td[3]"));


        for (int i = 0; i < allNames.size(); i++) {
            TreeMap<String,String> map= new TreeMap<>();
            map.put(BrowserUtils.getText(allNames.get(i)), BrowserUtils.getText(allEmails.get(i)));
            System.out.println("map ="+map);
        }

    }

    @Test
    public void phoneNumbers() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/");

        WebElement tablePagination= driver.findElement(By.xpath("//a[contains(.,'Table Pagination')]"));
        tablePagination.click();

        WebElement rows= driver.findElement(By.cssSelector("#maxRows"));
        BrowserUtils.selectBy(rows,"0","index");

        List<WebElement> allNames=driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allNumbers=driver.findElements(By.xpath("//tr//td[4]"));

        TreeMap<String,Long> map=new TreeMap<>();

        for (int i = 0; i < allNames.size(); i++) {
            Thread.sleep(2000);
            map.put(BrowserUtils.getText(allNames.get(i)),Long.parseLong(BrowserUtils.getText(allNumbers.get(i)).replace("-","")));
        }
        System.out.println(map);
        System.out.println();

    }
}
