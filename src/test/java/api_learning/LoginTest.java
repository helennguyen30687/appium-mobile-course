package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.Point;
import io.appium.java_client.touch.offset.PointOption;
import platform.Platform;

import java.io.IOException;

public class LoginTest {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            MobileElement firstNextOnBoardingBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Next"));
            firstNextOnBoardingBtnElem.click();

            MobileElement secondNextOnBoardingBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Next"));
            secondNextOnBoardingBtnElem.click();

            MobileElement loginOnBoardingBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login Now"));
            loginOnBoardingBtnElem.click();

            MobileElement mobileNoLoginInputElem = appiumDriver.findElement(MobileBy.xpath("//android.view.View[@content-desc='Welcome!']/following-sibling::android.widget.EditText"));
            MobileElement continueLoginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Continue"));
            mobileNoLoginInputElem.click();
            mobileNoLoginInputElem.sendKeys("0123456788");
            continueLoginBtnElem.click();

            MobileElement otpLoginInputElem = appiumDriver.findElement(MobileBy.xpath("//android.view.View[contains(@content-desc,'Enter the 4-digit')]/following-sibling::android.widget.EditText"));

            //DEBUG PURPOSE
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
