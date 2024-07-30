package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.login.LoginFormComponent_Lesson18;
import models.pages.LoginScreen_Lesson18;
import org.apache.commons.validator.routines.EmailValidator;
import test_flows.BaseFlow_Lesson19;

public class LoginFlow_Lesson19 extends BaseFlow_Lesson19 {

    private String username;
    private String password;

    public LoginFlow_Lesson19(AppiumDriver<MobileElement> appiumDriver, String username, String password) {
        super(appiumDriver);
        this.username = username;
        this.password = password;
    }

    public void login() {
        LoginScreen_Lesson18 loginScreen_lesson18 = new LoginScreen_Lesson18(appiumDriver);
        LoginFormComponent_Lesson18 loginFormComponent_lesson18 = loginScreen_lesson18.loginFormCom();

        if (!username.isEmpty()) {
            loginFormComponent_lesson18.inputUsername(username);
        }

        if (!password.isEmpty()) {
            loginFormComponent_lesson18.inputPassword(password);
        }

        loginFormComponent_lesson18.clickLoginBtn();
    }

    public void verifyLogin() {
        LoginScreen_Lesson18 loginScreen_lesson18 = new LoginScreen_Lesson18(appiumDriver);
        LoginFormComponent_Lesson18 loginFormComponent_lesson18=loginScreen_lesson18.loginFormCom();

        boolean isEmailValid = EmailValidator.getInstance().isValid(username);
        boolean isPasswordValid = password.length() >= 8;

        if (isEmailValid && isPasswordValid) {
            verifyCorrectLoginCreds();
        }

        if (!isEmailValid) {
            verifyIncorrectEmail(loginFormComponent_lesson18);
        }

        if (!isPasswordValid) {
            verifyIncorrectPassword(loginFormComponent_lesson18);
        }
    }

    // TODO:Homework
    private void verifyCorrectLoginCreds() {
        System.out.println("Login successfully");
    }

    private void verifyIncorrectEmail(LoginFormComponent_Lesson18 loginFormComp_Lesson18) {
       String actualInvalidEmailStr=loginFormComp_Lesson18.getInvalidEmailStr();
       String expectedInvalidEmailStr="Please enter a valid email address";

        System.out.println("actualInvalidEmailStr: "+actualInvalidEmailStr);
        System.out.println("expectedInvalidEmailStr: "+expectedInvalidEmailStr);
    }

    private void verifyIncorrectPassword(LoginFormComponent_Lesson18 loginFormComp_Lesson18) {
        String actualInvalidPasswordStr=loginFormComp_Lesson18.getInvalidPasswordStr();
        String expectedInvalidPasswordStr="Please enter at least 8 characters";

        System.out.println("actualInvalidPasswordStr: "+actualInvalidPasswordStr);
        System.out.println("expectedInvalidPasswordStr: "+expectedInvalidPasswordStr);
    }
}
