package com.lemon.pages;

import com.lemon.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2022/2/25 21:35
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class GoodsDetailPage extends BasePage {
    //添加购物车元素
    private By addCart = By.linkText("加入购物车");
    //商品标题
    private By goodsTitle = By.xpath("//div[@class='name-box']//div[@class='name']");
    //商品价格
    private By goodsPrice = By.xpath("//div[@class='price-box']//div[@class='price']");
    //商品数量
    private By goodsNum = By.xpath("//input[@type='number']");

    public GoodsDetailPage(WebDriver driver){
        super(driver);
    }

    public void clickAddCart(){
        //waitElementClickable(driver,addCart).click();
        click(addCart,"商品详情页-点击添加到购物车");
    }

    /**
     * 获取商品标题的操作
     * @return
     */
    public String getGoodsTitle(){
        return getElementText(goodsTitle,"商品详情页-商品标题");
    }

    public String getGoodsPrice(){
        //去掉换行符
        //商品价格：￥
        //0
        //.01
        //￥0.01
        return getElementText(goodsPrice,"商品详情页-商品价格").replaceAll("\n","");
    }

    public String getGoodsNum(){
        return getElementAttribute(goodsNum,"value","商品详情页-商品数量");
    }
}
