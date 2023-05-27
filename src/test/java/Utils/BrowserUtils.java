package Utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserUtils {

    public static String getText(WebElement element){
        return element.getText().trim();
    }

    public static void selectBy(WebElement location, String value,String methodName){

        Select select=new Select(location);

        switch (methodName){
            case "text":
               select.selectByVisibleText(value);
               break;
            case "value":
            select.selectByValue(value);
            break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Your methodname is not correct");
                Assert.assertTrue(false);
        }
    }
}
