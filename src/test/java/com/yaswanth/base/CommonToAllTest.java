package com.yaswanth.base;

import com.yaswanth.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {
    @BeforeMethod
    public void setup(){
        DriverManager.init();
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.down();

    }

}
