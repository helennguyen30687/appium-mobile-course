package test_flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.LoginScreen_Lesson18;

public class BaseFlow_Lesson19 {
    protected final AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow_Lesson19(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void goToLoginScreen(){
        new LoginScreen_Lesson18(appiumDriver).bottomNavComp().clickOnLoginIcon();
    }
}
