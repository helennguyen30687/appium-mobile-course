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

public class SwipeHorizontally_Lesson33_Lab16 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            // Navigate to Form screen
            MobileElement navFormScreenBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Swipe"));
            navFormScreenBtn.click();

            // Wait until user is on the form screen
            WebDriverWait wait = new WebDriverWait(appiumDriver,10L);
            wait.until(ExpectedConditions.
                    visibilityOfElementLocated(MobileBy.
                            AndroidUIAutomator("new UiSelector().textContains(\"Swipe horizontal\")")));

            // Get Mobile window size
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            // Calculate touch points
            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 10 * screenWidth / 100;

            int yStartPoint = 70 * screenHeight / 100;
            int yEndPoint = 70 * screenHeight / 100;

            // Convert coordinates -> PointOption
            PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint,yStartPoint);
            PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint,yEndPoint);

            // Swipe from right to left
            TouchAction touchAction = new TouchAction(appiumDriver);
            for (int time = 0; time < 5; time++) {
                touchAction
                        .press(startPoint)
                        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                        .moveTo(endPoint)
                        .release()
                        .perform();
            }

            // Swipe from left to right
            PointOption startPoint2 = new PointOption<>().withCoordinates(xEndPoint,yEndPoint);
            PointOption endPoint2 = new PointOption<>().withCoordinates(xStartPoint,yStartPoint);
            for (int time = 0; time < 5; time++) {
                touchAction
                        .press(startPoint2)
                        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                        .moveTo(endPoint2)
                        .release()
                        .perform();
            }

            // Click on Btn-active
//            MobileElement activeBtn = appiumDriver.findElement(MobileBy.AccessibilityId("button-Active"));
//            activeBtn.click();

        }catch (Exception e){
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
