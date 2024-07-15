package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent;
import models.components.login.LoginFormComponent;
import models.pages.Lesson18_LoginScreen;
import platform.Platform;

public class Lesson18_POM_LoginWithComponents {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            Lesson18_LoginScreen lesson18_loginScreen = new Lesson18_LoginScreen(appiumDriver);
            BottomNavComponent bottomNavComponent = lesson18_loginScreen.bottomNavComp();
            LoginFormComponent loginFormComponent = lesson18_loginScreen.loginFormCom();

            bottomNavComponent.clickOnLoginIcon();
            loginFormComponent.inputUsername("huong@gmail.com");
            loginFormComponent.inputPassword("12345678");
            loginFormComponent.clickLoginBtn();

            //DEBUG PURPOSE
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
