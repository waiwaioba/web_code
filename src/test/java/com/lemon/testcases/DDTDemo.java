package com.lemon.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2022/3/4 20:07
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class DDTDemo {
    @Test(dataProvider = "getDatas")
    public void test(String phone, String pwd){
        System.out.println("手机号:"+phone+",密码:"+pwd);
    }

    @DataProvider
    public Object[][] getDatas(){
        Object[][] datas = {{"18122224444","123456"},
                {"18122225555","123456"},
                {"18122226666","123456"}};
        return datas;
    }
}
