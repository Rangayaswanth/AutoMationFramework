package com.yaswanth.pages.pageObjectModel.OrangeHR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeListHomePage {
    WebDriver driver;

    public EmployeeListHomePage(WebDriver driver) {
        this.driver= driver;
    }
    By userNameOnDashBoard = By.xpath("//h6[normalize-space()='PIM']");


    public String loggedUserName(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(userNameOnDashBoard).getText();
    }












}
