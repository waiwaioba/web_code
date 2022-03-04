package com.lemon.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2022/2/25 20:35
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class BaseTest {
    private Logger logger = Logger.getLogger(BaseTest.class);
    public WebDriver driver;
    /**
     * 统一封装的打开浏览器的方法
     * @param browserName 对应浏览器名字
     */
    public WebDriver openBrowser(String browserName){
        if("chrome".equalsIgnoreCase(browserName)){
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
            logger.info("=====================打开了chrome浏览器====================");
            driver=new ChromeDriver();
            return driver;
        }else if("firefox".equalsIgnoreCase(browserName)){
            System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
            logger.info("=====================打开了Firefox浏览器====================");
            driver=new FirefoxDriver();
            return driver;
        }else if("ie".equalsIgnoreCase(browserName)){
            //取消IE安全设置（忽略IE的Protected Mode的设置）
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            //忽略IE的缩放设置问题
            capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            //告诉代码驱动程序放在那里
            System.setProperty("webdriver.ie.driver", "src\\test\\resources\\IEDriverServer.exe");
            logger.info("=====================打开了IE浏览器====================");
            driver=new InternetExplorerDriver(capabilities);
            return driver;
        }else {
            System.out.println("浏览器类型暂不支持，请确认你的浏览器名字是否正确");
            return null;
        }
    }

    /**
     * 访问对应网址
     * @param url 网址
     */
    public void toUrl(String url){
        //记录日志
        logger.info("访问网页【"+url+"】");
        driver.get(url);
    }


    /**
     * 断言的二次封装
     * @param actual 实际值
     * @param expect 期望值
     */
    public void myAssertEquals(String actual, String expect){
        //记录日志
        logger.info("比较断言,实际值【"+actual+"】期望值【"+expect+"】");
        Assert.assertEquals(actual,expect);
    }

    /**
     * 断言的二次封装
     * @param actual 实际值
     * @param expect 期望值
     */
    public void myAssertEquals(int actual, int expect){
        //记录日志
        logger.info("比较断言,实际值【"+actual+"】期望值【"+expect+"】");
        Assert.assertEquals(actual,expect);
    }

    /**
     * 断言的二次封装
     * @param actual 实际值
     * @param expect 期望值
     */
    public void myAssertEquals(short actual, short expect){
        //记录日志
        logger.info("比较断言,实际值【"+actual+"】期望值【"+expect+"】");
        Assert.assertEquals(actual,expect);
    }

    /**
     * 断言的二次封装
     * @param condition 条件表达式
     */
    public void myAssertTrue(boolean condition){
        logger.info("判断是否为真断言【"+condition+"】");
        Assert.assertTrue(condition);
    }


}
