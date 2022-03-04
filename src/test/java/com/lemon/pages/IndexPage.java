package com.lemon.pages;

import com.lemon.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2022/2/25 21:17
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class IndexPage extends BasePage {
    //登录链接
    private By login = By.xpath("//a[text()='登录']");
    //商品列表元素
    private By goodsList = By.linkText("商品列表");
    //要浏览的商品
    private By selectedGoods = By.xpath("//div[text()='商品名称']");
    //购物车
    private By cart = By.xpath("//span[@data-route='cart']");


    public IndexPage(WebDriver driver){
        super(driver);
    }

    public void clickLogin(){
        //driver.findElement(login).click();
        //waitElementClickable(driver,login).click();
        click(login,"主页-登录链接");
    }

    public void clickGoodslist(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //waitElementClickable(driver,goodsList).click();
        click(goodsList,"主页-商品列表");
    }

    public void selectGoods(){
        //waitElementClickable(driver,selectedGoods).click();
        click(selectedGoods,"主页-浏览商品");
    }

    public void clickCart(){
        //waitElementClickable(driver,cart).click();
        click(cart,"主页-购物车");
    }
}
