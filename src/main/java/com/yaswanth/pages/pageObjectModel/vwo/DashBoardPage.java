package com.yaswanth.pages.pageObjectModel.vwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
    WebDriver driver;

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }


    By UserNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");


    public String loggedInUserName(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return  driver.findElement(UserNameOnDashboard).getText();


    }









}
