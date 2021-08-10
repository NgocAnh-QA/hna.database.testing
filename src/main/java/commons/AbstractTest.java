package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AbstractTest {
    private WebDriver driver;

    protected WebDriver getBrowserDriver(String url, String osName, String osVersion, String browserName, String browserVersion){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", browserName);
        caps.setCapability("browser_version", browserVersion);
        caps.setCapability("os", osName);
        caps.setCapability("os_version", osVersion);
        caps.setCapability("name", "Run on " + osName + " and " + browserName + " with version " + browserVersion);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_STACK_URL), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;

    }
}
