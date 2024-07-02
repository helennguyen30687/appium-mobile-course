package context;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WaitMoreThanContext implements ExpectedCondition<Boolean> {
    private final AppiumDriver<MobileElement> appiumDriver;

    public WaitMoreThanContext(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver=appiumDriver;
    }

    @Override
    public Boolean apply(WebDriver input) {
        return appiumDriver.getContextHandles().size()>1;
    }
}
