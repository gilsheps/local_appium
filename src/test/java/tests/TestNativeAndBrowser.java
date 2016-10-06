package tests;

import base.BaseAppium;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by gilsheps on 22/09/2016.
 */
public class TestNativeAndBrowser extends BaseAppium{

    /*
     * 1. The will click on button by id - "btn"
     * 2. The driver will wait for object with id txt, will click on Apps button and than on Browser button.
     * 3. After the app opens that driver wait 3 sec.
     * 4. The driver will search all "android.widget.EditText" objects in the screen, the objects will go in List of WebElement
     * 5. In the first object, the driver will enters the URL and click on enter.
     * 6. The driver will wait for button by id od "Download".
     * 7. The driver will click on switch button do display the apps that in the background
     * 8. The driver will wait until the tested app will display on will click in order to open the app
     */

    @Test
    public void testNativeAndBrowser() {
        WebDriverWait uiWait = new WebDriverWait(driver, 30);
        driver.findElement(By.id("btn")).click();
        uiWait.until(ExpectedConditions.presenceOfElementLocated(By.id("txt")));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.HOME);
        waitFor3Sec();
        driver.findElement(By.id("Apps")).click();
        driver.findElement(By.id("Browser")).click();
        waitFor3Sec();
        List<WebElement> elements = driver.findElements(By.className("android.widget.EditText"));
        elements.get(0).sendKeys("https://www.meetup.com/Appium-Israel/events/233798589/");
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.ENTER);
        uiWait.until(ExpectedConditions.presenceOfElementLocated(By.id("Download")));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        uiWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='MyMeetupExpample']"))).click();
        uiWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt")));
    }
}
