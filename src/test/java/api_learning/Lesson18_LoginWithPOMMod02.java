package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.pages.Lesson18_LoginScreenMod02;
import platform.Platform;

public class Lesson18_LoginWithPOMMod02 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver= DriverFactory.getDriver(Platform.ANDROID);

        try {
            MobileElement navLoginScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtnElem.click();

            Lesson18_LoginScreenMod02 loginScreen = new Lesson18_LoginScreenMod02(appiumDriver);
            loginScreen.inputUsername ("huong@gmail.com");
            loginScreen.inputPassword("12354678");
            loginScreen.clickLoginBtn();

        }catch (Exception e){
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
