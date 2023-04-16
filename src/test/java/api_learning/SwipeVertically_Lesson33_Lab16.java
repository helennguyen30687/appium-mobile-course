package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.time.Duration;

public class SwipeVertically_Lesson33_Lab16 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            // Navigate to Form screen
            MobileElement navFormScreenBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
            navFormScreenBtn.click();

            // Wait until user is on the form screen
            WebDriverWait wait = new WebDriverWait(appiumDriver, 10L);
            wait.until(ExpectedConditions.
                    visibilityOfElementLocated(MobileBy.
                            AndroidUIAutomator("new UiSelector().textContains(\"Form components\")")));

            // Get Mobile window size
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            // Calculate touch points
            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 50 * screenWidth / 100;

            int yStartPoint = 50 * screenHeight / 100;
            int yEndPoint = 10 * screenHeight / 100;

            // Convert coordinates -> PointOption
            PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

            // Using TouchAction to swipe
            TouchAction touchAction = new TouchAction(appiumDriver);
            touchAction
                    .press(startPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                    .moveTo(endPoint)
                    .release()
                    .perform();

            MobileElement inputTextTextbox = appiumDriver.findElement(MobileBy.AccessibilityId("text-input"));
            MobileElement inputTextResultTextbox = appiumDriver.findElement(MobileBy.AccessibilityId("input-text-result"));
            MobileElement switchBtn = appiumDriver.findElement(MobileBy.AccessibilityId("switch"));
            MobileElement switchText = appiumDriver.findElement(MobileBy.AccessibilityId("switch-text"));
            MobileElement dropdown = appiumDriver.findElement(MobileBy.xpath("//android.widget.EditText[contains(@text,\"Select an item\")]"));

            inputTextTextbox.sendKeys("abcxyz");
            if (inputTextTextbox.getText().trim().equals(inputTextResultTextbox.getText())) {
                System.out.println(inputTextResultTextbox.getText());
            }
            switchBtn.click();
            if (switchText.getText().contains("OFF")) {
                System.out.println("Switch OFF");
            }

            dropdown.click();

            MobileElement valueDropdownSelect = appiumDriver.findElement(MobileBy.xpath("//android.widget.CheckedTextView[contains(@text,\"Appium is awesome\")]"));
            valueDropdownSelect.click();
            // Swipe down | trick: revert coordinates
            /*  .press(startPoint)
             *       .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
             *  Can be replaced to: longPress(endPoint)
             */
//            touchAction
//                    .longPress(endPoint)
//                    .moveTo(startPoint)
//                    .release()
//                    .perform();

            // Click on Btn-active
            MobileElement activeBtn = appiumDriver.findElement(MobileBy.AccessibilityId("button-Active"));
            activeBtn.click();

        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
