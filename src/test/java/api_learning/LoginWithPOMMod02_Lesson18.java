package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.pages.LoginScreenMod02_Lesson18;
import platform.Platform;

public class LoginWithPOMMod02_Lesson18 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver= DriverFactory.getDriver(Platform.ANDROID);

        try {
            MobileElement navLoginScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtnElem.click();

            LoginScreenMod02_Lesson18 loginScreen = new LoginScreenMod02_Lesson18(appiumDriver);
            loginScreen.inputUsername ("huong@gmail.com");
            loginScreen.inputPassword("12354678");
            loginScreen.clickLoginBtn();

        }catch (Exception e){
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
