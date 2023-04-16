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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NarrowDownSearchingScope_Lesson33_Lab16 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            // Navigate to Form screen
            MobileElement navFormScreenBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
            navFormScreenBtn.click();

            // Wait until user is on the form screen
            WebDriverWait wait = new WebDriverWait(appiumDriver,10L);
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

            int yStartPoint = 0 ;
            int yEndPoint = 10 * screenHeight / 100;

            // Convert coordinates -> PointOption
            PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint,yStartPoint);
            PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint,yEndPoint);

            // Using TouchAction to swipe
            TouchAction touchAction = new TouchAction(appiumDriver);
            touchAction
                    .press(startPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                    .moveTo(endPoint)
                    .release()
                    .perform();

            List<MobileElement> notificationElems =
                    appiumDriver.findElements(MobileBy.id("android:id/notification_main_column"));
            Map<String,String> notificationContents = new HashMap<>();
            for (MobileElement notificationElem : notificationElems) {
                MobileElement titleElem = notificationElem.findElement(MobileBy.id("android:id/title"));
                MobileElement textElem = notificationElem.findElement(MobileBy.id("android:id/text"));
                notificationContents.put(titleElem.getText().trim(),textElem.getText().trim());
            }

            // Verification
            // False negative
            if(notificationContents.keySet().isEmpty())
                throw new RuntimeException("No notification");

            for (String title : notificationContents.keySet()) {
                System.out.println("Title: " + title);
                System.out.println("Content: " + notificationContents.get(title));
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
