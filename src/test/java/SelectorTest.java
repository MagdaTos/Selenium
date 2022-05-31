import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorTest {

    @Test
    public void findElements() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        //clickOnMe button
        By buttonId = By.id("clickOnMe");
        WebElement clickOnMeButton = driver.findElement(buttonId);

        //fname input
//        By firstName = By.name("fname");
//        WebElement firstNameInput = driver.findElement(firstName);
        WebElement firstNameInput2 = driver.findElement(By.name("fname"));

        //topSecret
        WebElement paraHidden = driver.findElement(By.className("topSecret"));
        // tak samo
        // By paraHidden = By.className("topSecret");
        //driven.findElement(paraHidden);

        By input1 = By.tagName("input");
        WebElement input =driver.findElement(input1);
        input.sendKeys("Pierwszy");
        List<WebElement> inputs = driver.findElements(input1);
        System.out.println(inputs.size());

        WebElement schoolLink = driver.findElement(By.linkText("Visit W3Schools.com!"));

        WebElement partialLink = driver.findElement(By.partialLinkText("Visit"));

    }
}
