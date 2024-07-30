package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent_Lesson18;
import models.components.login.LoginFormComponent_Lesson18;

public class LoginScreen_Lesson18 {
    private final AppiumDriver<MobileElement> appiumDriver;

    public LoginScreen_Lesson18(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LoginFormComponent_Lesson18 loginFormCom(){
        return new LoginFormComponent_Lesson18(appiumDriver);
    }

    public BottomNavComponent_Lesson18 bottomNavComp(){
        return new BottomNavComponent_Lesson18(appiumDriver);
    }
}
