package com.lemon.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2022/2/28 20:44
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class Log4jTest {
    //日志对象的初始化
    private Logger logger = Logger.getLogger(Log4jTest.class);
    @Test
    public void test(){
        //要通过log4j记录日志
        logger.error("这是错误级别的日志");
        logger.warn("这是警告级别的日志");
        logger.info("这是一般提示信息级别的日志");
        logger.debug("这是调试级别的日志");
    }
}
