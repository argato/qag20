package tests;

import drivers.BrowserstackAndroidDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSElement;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Tag("ios")
public class BrowserStackIosSampleTests extends TestBase {

  @Test
  void searchTest() throws InterruptedException {

    IOSElement textButton = (IOSElement) new WebDriverWait(BrowserstackAndroidDriver.iosDriver,
                                                           30).until(
        ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Button")));
    textButton.click();
    IOSElement textInput = (IOSElement) new WebDriverWait(BrowserstackAndroidDriver.iosDriver,
                                                          30).until(
        ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Input")));
    textInput.sendKeys("hello@browserstack.com");
    Thread.sleep(5000);
    IOSElement textOutput = (IOSElement) new WebDriverWait(BrowserstackAndroidDriver.iosDriver,
                                                           50).until(
        ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Output")));
    if (textOutput != null && textOutput.getText().equals("hello@browserstack.com")) {
      assert (true);
    } else {
      assert (false);
    }
  }
}