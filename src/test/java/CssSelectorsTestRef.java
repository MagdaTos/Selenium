import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectorsTestRef {
    @Test
            public void findElements() {

    WebDriverManager.chromedriver().setup();

    WebDriver driver = new ChromeDriver();
    driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
    By cssId = By.cssSelector("#clickOnMe");
    driver.findElement(cssId);

    By cssClass = By.cssSelector(".topSecret");
    driver.findElement(cssClass);

    By cssTag = By.cssSelector("input");
    driver.findElement(cssTag);

    By cssName =By.cssSelector("[name='fname']");
    driver.findElement(cssName);

}
}
