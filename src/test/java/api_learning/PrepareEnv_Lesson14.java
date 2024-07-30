package api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class PrepareEnv_Lesson14 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = null;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("udid", "2adeffce");
        desiredCapabilities.setCapability("appPackage", "com.mfast.mfastph.stag");
        desiredCapabilities.setCapability("appActivity", "com.mfast.mfastph.MainActivity");

        try {
            URL appiumServer = new URL("http://localhost:4723/wd/hub");
            appiumDriver = new AndroidDriver<MobileElement>(appiumServer, desiredCapabilities);
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }
}
