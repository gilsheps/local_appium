package tests;

import base.BaseAppium;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by gilsheps on 22/09/2016.
 */
public class TestTwoAppsInOneTest extends BaseAppium {

    /*
   * 1. The will click on button by id - "btn"
   * 2. The driver will wait for object with id txt.
   * 3. The driver will check if the second app installed, if not the driver will install the app
   * 4. The driver will open the second app and will wait until the object will display, than the driver will click on the object
   * 5. The driver will send text to object with id "com.mtvn.mtvPrimeAndroid:id/search_query"
   * 6. The driver will click on switch button do display the apps that in the background
   * 7. The driver will wait until the tested app will display on will click in order to open the app
   */

    @Test
    public void testSecondApp() {
        WebDriverWait uiWait = new WebDriverWait(driver, 30);
        driver.findElement(By.id("btn")).click();
        uiWait.until(ExpectedConditions.presenceOfElementLocated(By.id("txt")));
        if (!driver.isAppInstalled("com.mtvn.mtvPrimeAndroid")){
            driver.installApp(System.getProperty("user.dir") + File.separator + "src" + File.separator + "resources"+ File.separator + "MTV_v3.0.7_apkpure.com.apk");
        }
        ((AndroidDriver)driver).startActivity("com.mtvn.mtvPrimeAndroid","com.vmn.android.me.MainActivity");
        uiWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mtvn.mtvPrimeAndroid:id/menu_search"))).click();
        driver.findElement(By.id("com.mtvn.mtvPrimeAndroid:id/search_query")).sendKeys("hello");
        waitFor3Sec();
        ((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        uiWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='MyMeetupExpample']"))).click();
        uiWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt")));
    }
}
