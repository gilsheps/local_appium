package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

/**
 * Created by gilsheps on 06/10/2016.
 */
public abstract  class BaseAppium {
    protected AppiumDriver driver;
    // setup of the driver
    @Before
    public void setUp() throws Exception {
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        final File appDir = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "resources");
        final File app = new File(appDir, "MeetupAppExample.apk");
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("deviceType", "phone");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "5.1");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.example.MyMeetupExpample");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("fullReset", false);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    // after the test end the driver will close
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    // function to wait 3 sec
    public void waitFor3Sec() {
        try {
            java.lang.Thread.sleep(3 * 1000);
        } catch (InterruptedException ignore) {
        }
    }
}
