package com.yaswanth.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.yaswanth.driver.DriverManager.getDriver;

public class CommonToAllPage {

    public CommonToAllPage(){

    }



    public void clickElement(By by){
        getDriver().findElement(by).click();
    }
    public void clickElement(WebElement by){
        by.click();
    }
    public void enterInput(By by){
        getDriver().findElement(by).sendKeys();
    }
    public void enterInput(WebElement by){
        by.sendKeys();
    }
    public void getText(By by){
        getDriver().findElement(by).getText();
    }











}
