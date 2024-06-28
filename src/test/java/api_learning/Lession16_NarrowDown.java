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

public class Lession16_UISelector_Vertical_Horizontal {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            MobileElement navLoginScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtnElem.click();

            //UiSelector
            MobileElement loginIntroductionTextElem =
                    appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"When the device has Touch/FaceID\")"));
            System.out.println(loginIntroductionTextElem.getText());

            //VERTICAL
            MobileElement navFormScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
            navFormScreenBtnElem.click();

            WebDriverWait wait = new WebDriverWait(appiumDriver, 10L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Form components\")")));

            //Swipe Vertical
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            int xStartPointVertical = (screenWidth * 50) / 100;
            int xEndPointVertical = (screenWidth * 50) / 100;

            int yStartPointVertical = (screenHeight * 50) / 100;
            int yEndPointVertical = (screenHeight * 10) / 100;

            //Convert Coordinate => pointOption
            PointOption startPoint = new PointOption<>().withCoordinates(xStartPointVertical, yStartPointVertical);
            PointOption endPoint = new PointOption<>().withCoordinates(xEndPointVertical, yEndPointVertical);


            /*
             * .press(startPoint)
             * .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
             * replace to: longPress
             * */
            TouchAction touchAction = new TouchAction(appiumDriver);
            touchAction
                    .longPress(startPoint)
                    .moveTo(endPoint)
                    .release()
                    .perform();

            //HORIZONTAL

            MobileElement navSwipeScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Swipe"));
            navSwipeScreenBtnElem.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Swipe horizontal\")")));

            //Swipe Horizontal

            int xStartPointHorizontal = (screenWidth * 50) / 100;
            int xEndPointHorizontal = (screenWidth * 10) / 100;

            int yStartPointHorizontal = (screenHeight * 70) / 100;
            int yEndPointHorizontal = (screenHeight * 70) / 100;

            //Convert Coordinate => pointOption
            PointOption startPointHorizontal = new PointOption<>().withCoordinates(xStartPointHorizontal, yStartPointHorizontal);
            PointOption endPointHorizontal = new PointOption<>().withCoordinates(xEndPointHorizontal, yEndPointHorizontal);
            for (int time = 0; time < 5; time++) {
                touchAction
                        .longPress(startPointHorizontal)
                        .moveTo(endPointHorizontal)
                        .release()
                        .perform();
            }

            //DEBUG PURPOSE
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
