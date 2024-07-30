package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent_Lesson18;
import models.components.login.LoginFormComponent_Lesson18;
import models.pages.LoginScreen_Lesson18;
import platform.Platform;

public class POM_LoginWithComponents_Lesson18 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            LoginScreen_Lesson18 loginScreen_lesson18 = new LoginScreen_Lesson18(appiumDriver);
            BottomNavComponent_Lesson18 lesson18_bottomNavComponent = loginScreen_lesson18.bottomNavComp();
            LoginFormComponent_Lesson18 loginFormComponent_Lesson18 = loginScreen_lesson18.loginFormCom();

            lesson18_bottomNavComponent.clickOnLoginIcon();
            loginFormComponent_Lesson18.inputUsername("huong@gmail.com");
            loginFormComponent_Lesson18.inputPassword("12345678");
            loginFormComponent_Lesson18.clickLoginBtn();

            //DEBUG PURPOSE
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
