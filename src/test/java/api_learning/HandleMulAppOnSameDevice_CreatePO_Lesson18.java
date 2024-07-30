package api_learning;

import driver.AppPackage;
import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.time.Duration;
import java.util.List;

public class HandleMulAppOnSameDevice_CreatePO_Lesson18 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            MobileElement navLoginScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtnElem.click();

            MobileElement emailInputElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordInputElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            emailInputElem.sendKeys("huong@gmail.com");
            passwordInputElem.sendKeys("12345678");
            loginBtnElem.click();

            //Put the app under test to background in a certain time | simulate pressing home button >relaunch
            //   appiumDriver.runAppInBackground(Duration.ofSeconds(3));

            //Put the app under test to background till we call it back
            appiumDriver.runAppInBackground(Duration.ofSeconds(-1));

            //Switch into another app | Go to Settings toggle wifi
            appiumDriver.activateApp(AppPackage.SETTINGS);

            //Navigate to network list
            By networkAndInternetLabelSel = MobileBy.xpath("//*[@text='Network & internet']");
            appiumDriver.findElement(networkAndInternetLabelSel).click();

            WebDriverWait wait = new WebDriverWait(appiumDriver, 15L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[@text='Internet']")));
            By internetLabelSel = MobileBy.xpath("//*[@text='Internet']");
            appiumDriver.findElement(internetLabelSel).click();

            //Toggle ON/OFF
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[@text='Network preferences']")));
            MobileElement wifiBtnElem = appiumDriver.findElement(MobileBy.id("android:id/switch_widget"));

            List<MobileElement> wifiStatusListElems = appiumDriver.findElements(MobileBy.xpath("//*[@text='AndroidWifi']"));
            if (wifiStatusListElems.isEmpty()) {
                wifiBtnElem.click();
            }

            //Come back to the app > interact with other elements
            appiumDriver.activateApp(AppPackage.WEBDRIVER_IO);
            appiumDriver.findElement(MobileBy.xpath("//*[@text='OK']")).click();

            //DEBUG PURPOSE
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
