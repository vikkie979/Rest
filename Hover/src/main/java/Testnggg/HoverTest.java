package Testnggg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class HoverTest {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void hoverExample() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        // Hover over the first figure
        WebElement figure = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();
        // Click "View profile" after hovering
        WebElement viewProfile = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/a"));
        viewProfile.click();
        // Verify redirected URL or element
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Navigated to: " + currentUrl);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}






