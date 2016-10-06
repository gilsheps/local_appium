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
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by gilsheps on 22/09/2016.
 */
public class TestCalculatorApp extends BaseAppium {

    /*
   * 1. The will click on button by id - "btn"
   * 2. The driver will wait 3 sec and than will click on home button,will click on Apps button and than on Calculator button.
   * 3.  After the app opens that driver will click on 3 and than on plus and than on 2
   * 4. In the end the driver will click on equals
   * 5. The last line, i'm using junit for assert example
   * 6. The driver will click on switch button do display the apps that in the background
   * 7. The driver will wait until the tested app will display on will click in order to open the app
   */

    @Test
    public void calculateTwoNumbers() {
        if (driver.findElement(By.id("btn")).isDisplayed()) {
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.HOME);
            waitFor3Sec();
            driver.findElement(By.id("Apps")).click();
            driver.findElement(By.id("Calculator")).click();
            waitFor3Sec();
            driver.findElement(By.xpath("//android.widget.Button[@text='3']")).click();
            driver.findElement(By.id("plus")).click();
            driver.findElement(By.xpath("//android.widget.Button[@text='2']")).click();
            driver.findElement(By.id("equals")).click();
            waitFor3Sec();
            Assert.assertTrue(driver.findElement(By.xpath("//android.widget.EditText[@text='5']")).isDisplayed());
        }
    }

}
