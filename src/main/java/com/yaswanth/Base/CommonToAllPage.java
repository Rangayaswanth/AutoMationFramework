package com.yaswanth.Base;

import com.yaswanth.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.yaswanth.driver.DriverManager.getDriver;

public class CommonToAllPage {

    public CommonToAllPage(){

    }
    public void openVWOUrl(){
        getDriver().get(PropertiesReader.readKey("url"));
    }


    public void clickElement(By by){
        getDriver().findElement(by).click();
    }
    public void clickElement(WebElement by){
        by.click();
    }
    public void enterInput(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }
    public void enterInput(WebElement by, String key) {
        by.sendKeys(key);
    }
    public void enterInput(WebElement by){
        by.sendKeys();
    }
    public String getText(By by){
      return getDriver().findElement(by).getText();
    }
    public String getText(WebElement by){
        return by.getText();
    }
    public WebElement presenceOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    public WebElement getElement(By key) {
        return getDriver().findElement(key);
    }











}
