package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.pages.LoginScreenMod01_Lesson18;
import platform.Platform;

public class LoginWithPOMMod01_Lesson18 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver= DriverFactory.getDriver(Platform.ANDROID);

        try {
            MobileElement navLoginScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtnElem.click();

            LoginScreenMod01_Lesson18 loginScreen = new LoginScreenMod01_Lesson18(appiumDriver);
            loginScreen.userNameElem().sendKeys("huong@gmail.com");
            loginScreen.passwordElem().sendKeys("12354678");
            loginScreen.loginBtnElem().click();

        }catch (Exception e){
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
