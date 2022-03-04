package com.lemon.testcases;

import com.lemon.common.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2022/3/2 21:11
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class ScreenshotTest extends BaseTest {
    @Test
    public void test() throws InterruptedException, IOException {
        WebDriver driver = openBrowser("chrome");
        driver.get("https://www.baidu.com");
        Thread.sleep(2000);
        //截图 getScreenshotAs
        //driver.getScreenshotAs();
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir")+"\\target\\test.png");
        FileUtils.copyFile(srcFile,destFile);
        //D:\workspace_intellij\web_auto_35_36\target
        ;
    }
}
