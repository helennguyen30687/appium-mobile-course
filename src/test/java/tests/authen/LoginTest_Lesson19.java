package tests.authen;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import platform.Platform;
import test_flows.authentication.LoginFlow_Lesson19;

import java.util.ArrayList;
import java.util.List;

public class LoginTest_Lesson19 {

    @Test
    public void testLogin() {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        List<LoginCred> loginCreds = new ArrayList<>();
        loginCreds.add(new LoginCred("huong@", "12345678"));
        loginCreds.add(new LoginCred("huong@gmail.com", "1234567"));
        loginCreds.add(new LoginCred("huong@gmail.xyz", "12345678"));

        try {
            for(LoginCred loginCred:loginCreds){
                LoginFlow_Lesson19 loginFlow_lesson19 =new LoginFlow_Lesson19(appiumDriver,loginCred.getEmail(),loginCred.getPassword());
                loginFlow_lesson19.goToLoginScreen();
                loginFlow_lesson19.login();
                loginFlow_lesson19.verifyLogin();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }

    public static class LoginCred {
        private String email;
        private String password;

        public LoginCred(String email, String password) {
            this.password = password;
            this.email = email;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }
    }
}
