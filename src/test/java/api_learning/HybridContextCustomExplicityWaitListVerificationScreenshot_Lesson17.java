package api_learning;

import context.Contexts;
import context.WaitMoreThanContext;
import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.util.ArrayList;
import java.util.List;

public class HybridContextCustomExplicityWaitListVerificationScreenshot_Lesson17 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            By webViewNavBtnSel = MobileBy.AccessibilityId("Webview");
            MobileElement webViewNavBtnElem = appiumDriver.findElement(webViewNavBtnSel);
            webViewNavBtnElem.click();


            //Wait until have one more than context
            WebDriverWait wait = new WebDriverWait(appiumDriver, 15L);
            wait.until(new WaitMoreThanContext(appiumDriver));

            //print all context
            for (String contextHandle : appiumDriver.getContextHandles()) {
                System.out.println(contextHandle);
            }

            //Switch to Webview
            appiumDriver.context(Contexts.WEB_VIEW);
            WebElement navToggleBtnElem = appiumDriver.findElementByCssSelector(".navbar__toggle");
            navToggleBtnElem.click();

            List<MobileElement> menuItemsElem = appiumDriver.findElementsByCssSelector(".menu__list li a");
           // Map<String, String> menuItemDataMap = new HashMap<>();  FOR MAP ONLY
            List<MenuItemData> menuItemDataList=new ArrayList<>();

            if (menuItemsElem.isEmpty())
                throw new RuntimeException("[ERROR] There is no list items!");
            for (MobileElement menuItemElem : menuItemsElem) {
                String itemText = menuItemElem.getText();
                String itemHref = menuItemElem.getAttribute("href");
                String itemAttribute = menuItemElem.getAttribute("aria-label");

                if (itemText.isEmpty() &&itemAttribute.contains("GitHub")){
                  //  menuItemDataMap.put("GitHub",itemHref);  FOR MAP ONLY
                    menuItemDataList.add(new MenuItemData("GitHub",itemHref));
                }
                if (itemText.isEmpty() &&itemAttribute.contains("Twitter")){
                    menuItemDataList.add(new MenuItemData("Twitter",itemHref));
                }
                if (itemText.isEmpty() &&itemAttribute.contains("YouTube")){
                    menuItemDataList.add(new MenuItemData("YouTube",itemHref));
                }
                if (itemText.isEmpty() &&itemAttribute.contains("Discord")){
                    menuItemDataList.add(new MenuItemData("Discord",itemHref));
                }
                else {
                    menuItemDataList.add(new MenuItemData(itemText,itemHref));
                }
            }

//          FOR MAP ONLY
//            for(String itemText: menuItemDataMap.keySet() ){
//                System.out.println("itemText: " + itemText);
//                System.out.println("itemHref: " + menuItemDataMap.get(itemText));
//            }

            for (MenuItemData menuItemData:menuItemDataList){
                System.out.println(menuItemData);
            }

            //Switch to native app
            appiumDriver.context(Contexts.NATIVE_APP);

            //DEBUG PURPOSE
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
    public static class MenuItemData{
        private String name;
        private String href;

        public MenuItemData(String href, String name) {
            this.href = href;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getHref() {
            return href;
        }

        @Override
        public String toString() {
            return "MenuItemData{" +
                    "name='" + name + '\'' +
                    ", href='" + href + '\'' +
                    '}';
        }
    }
}
