package api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class LaunchAppTest {
    public static void main(String[] args) {
        
        //send request to appium server > ask to launch the app
        AppiumDriver<MobileElement> appiumDriver = null;

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("automativeName","uiautomator2");
        desiredCapabilities.setCapability("udid","emulator-5554");
        desiredCapabilities.setCapability("appPackage","com.wdiodemoapp");
        desiredCapabilities.setCapability("appActivity","com.wdiodemoapp.MainActivity");

        //init appium session
        try {
            URL appiumServer = new URL("http://localhost:4725/wd/hub");
            appiumDriver = new AndroidDriver<>(appiumServer, desiredCapabilities);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(appiumDriver!=null)
            appiumDriver.quit();
    }
}
