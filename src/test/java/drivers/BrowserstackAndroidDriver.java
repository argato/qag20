package drivers;


import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import config.MobileConfig;
import helpers.Browserstack;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserstackAndroidDriver implements WebDriverProvider {


    public static final BrowserstackConfig browserstackConfig =
        ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    public static final MobileConfig mobileConfig =
        ConfigFactory.create(MobileConfig.class, System.getProperties());
    public static WebDriver iosDriver;

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("browserstack.user", browserstackConfig.username());
        desiredCapabilities.setCapability("browserstack.key", browserstackConfig.key());

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", mobileConfig.appUrl());

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", mobileConfig.device());
        desiredCapabilities.setCapability("os_version", mobileConfig.os());

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "First Project");

        if (System.getProperty("environment") == "ios") {
            desiredCapabilities.setCapability("build", "IOS Build");
            desiredCapabilities.setCapability("name", "first_test");
            iosDriver = new IOSDriver(Browserstack.getBrowserstackUrl(), desiredCapabilities);
            return iosDriver;
        } else {
            desiredCapabilities.setCapability("build", "Android Build");
            desiredCapabilities.setCapability("name", "first_test_wiki");
            return new AndroidDriver(Browserstack.getBrowserstackUrl(), desiredCapabilities);
        }

    }
}
