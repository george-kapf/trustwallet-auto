package tests;

import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utils.DriverUtils;

import java.io.File;
import java.nio.file.Files;

@Listeners(ChainTestListener.class)
public class BaseTest {

    @BeforeClass
    public void setUp() {
        DriverUtils.initializeDriver();
    }

    @AfterMethod
    public void attachScreenShot(final ITestResult result) {
        try {
            ChainTestListener.log("log message :"+result.getMethod().getMethodName());
            File screenshot = ((TakesScreenshot) DriverUtils.getDriver()).getScreenshotAs(OutputType.FILE);
            byte[] screenshotBytes = Files.readAllBytes(screenshot.toPath());
            ChainTestListener.embed(screenshotBytes, "image/png");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void tearDown() {
        if (DriverUtils.getDriver() != null ) {
            DriverUtils.quitDriver();
        }
    }


}
