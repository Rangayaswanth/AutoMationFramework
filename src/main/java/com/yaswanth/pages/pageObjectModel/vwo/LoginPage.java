package com.yaswanth.pages.pageObjectModel.vwo;

import com.yaswanth.Base.CommonToAllPage;
import com.yaswanth.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.util.Properties;

public class LoginPage extends CommonToAllPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    //page class
    //page Locators
    //page actions


    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");


    public String loginToVWOLoginInvalidCreds(String user, String pwd) {
        openVWOUrl();
        //driver.findElement(username).sendKeys(user);
        enterInput(username, user);
        enterInput(password, pwd);
        clickElement(signButton);
        presenceOfElement(error_message);
        return getText(error_message);
//        driver.findElement(password).sendKeys(pwd);
//        driver.findElement(signButton).click();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        String error_message_text = driver.findElement(error_message).getText();
//        return error_message_text;
    }

        public void loginToVWOLoginvalidCreds (String user, String pwd){
            openVWOUrl();
            enterInput(username, user);
            enterInput(password, pwd);
            clickElement(signButton);
//            driver.findElement(username).sendKeys(user);
//            driver.findElement(password).sendKeys(pwd);
//            driver.findElement(signButton).click();
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }