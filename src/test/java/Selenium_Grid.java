import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Selenium_Grid extends AbstractTest {
    WebDriver driver;
    @Parameters({ "url", "os", "os_version", "browser", "browser_version"})
    @BeforeClass
    public void beforeClass(String url, String os, String osVersion, String browser, String browserVersion) {
        driver = getBrowserDriver(url, os, osVersion, browser, browserVersion);
    }



}
