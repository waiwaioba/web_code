package com.lemon.testcases;

import com.lemon.common.BaseTest;
import com.lemon.pages.CartPage;
import com.lemon.pages.GoodsDetailPage;
import com.lemon.pages.IndexPage;
import com.lemon.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2022/2/25 21:28
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class AddCartTest extends BaseTest {

    @BeforeTest
    public void setup(){
        //数据清洗？？
    }

    @Test
    @Parameters({"browserName"})
    public void add_one_success(String browserName){
        WebDriver driver = openBrowser(browserName);
        toUrl("http://mall.lemonban.com:3344/");
        //1、登录
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("waiwai","lemon123456");
        //2、浏览商品
        indexPage.clickGoodslist();
        indexPage.selectGoods();
        GoodsDetailPage goodsDetailPage = new GoodsDetailPage(driver);
        //获取商品的数据
        //（1）商品标题
        String goodsTitle1 = goodsDetailPage.getGoodsTitle();
        //（2）商品价格
        String goodsPrice1 = goodsDetailPage.getGoodsPrice();
        //（3）商品数量
        String goodsNum1 = goodsDetailPage.getGoodsNum();
        //3、添加购物车
        goodsDetailPage.clickAddCart();
        //4、点击购物车
        indexPage.clickCart();
        //获取购物车里面的商品数据
        CartPage cartPage = new CartPage(driver);
        String goodsTitle2 = cartPage.getGoodsTitle();
        String goodsPrice2 = cartPage.getGoodsPrice();
        String goodsNum2 = cartPage.getGoodsNum();
        //断言？？
        myAssertEquals(goodsTitle2,goodsTitle1);
        myAssertEquals(goodsPrice2,goodsPrice1);
        myAssertEquals(goodsNum2,goodsNum1);
    }

    @AfterTest
    public void teardown(){
        //清洗数据
    }
}
