package com.mobile.automation.framework.helpers;

import com.mobile.automation.framework.RunCucumber;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestListener implements ITestListener {
    AppiumDriver driver = null;
    private Logger log = Logger.getLogger(this.getClass().getSimpleName());
    private static final String SCREENSHOT_FOLDER = System.getProperty("user.dir") + File.separator + "logs" + File.separator + "screen" + File.separator + new SimpleDateFormat("MM_dd__hh_mm").format(new Date()) + File.separator;

    @Override
    public void onTestFailure(ITestResult result){
        String testClassName = getTestClassName(result.getInstanceName()).trim() + File.separator;
        String meatestNumber = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).description().split(" ", 2)[0];
        log.info("***** Error " + meatestNumber + " - " + result.getName() + " test has failed *****");
        takeScreenShot(meatestNumber, SCREENSHOT_FOLDER + testClassName + meatestNumber + ".png");
    }

    public void onFinish(ITestContext context){
    }

    public void onTestStart(ITestResult result){
    }

    public void onTestSuccess(ITestResult result){
    }

    public void onTestSkipped(ITestResult result){
        String testClassName = getTestClassName(result.getInstanceName()).trim() + File.separator;
        String meatestNumber = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).description().split(" ", 2)[0];
        log.info("***** Error " + meatestNumber + " - " + result.getName() + " test has failed *****");
        takeScreenShot("Skipped "+meatestNumber, SCREENSHOT_FOLDER + testClassName + meatestNumber + ".png");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result){
        String testClassName = getTestClassName(result.getInstanceName()).trim() + File.separator;
        String meatestNumber = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).description().split(" ", 2)[0];
        log.info("***** Error " + meatestNumber + " - " + result.getName() + " test has failed *****");
        takeScreenShot(meatestNumber, SCREENSHOT_FOLDER + testClassName + meatestNumber + ".png");
    }

    public void onStart(ITestContext context){
    }

    private void takeScreenShot(String meatestNumber, String pathName){
        driver = RunCucumber.driver;
        File scrFile = driver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(pathName));
            log.info("*** Placed screenshot in '" + pathName + "' ***\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getTestClassName(String testName){
        String[] reqTestClassname = testName.split(File.separator + ".");
        int i = reqTestClassname.length - 1;
        log.info("Test Name : " + reqTestClassname[i]);
        return reqTestClassname[i];
    }

}