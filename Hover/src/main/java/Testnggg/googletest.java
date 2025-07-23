package Testnggg;
import org.testng.Assert;
import org.testng.annotations.Test;
public class googletest extends BaseTest {
    @Test
    public void openGoogleTest() {
        test = extent.createTest("Open Google Home Page");
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        test.info("Page title is: " + title);
        Assert.assertTrue(title.contains("Google"));
        test.pass("Google opened successfully and title verified");
    }
}
