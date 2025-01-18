package com.yaswanth.pages.pageObjectModel.OrangeHR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHRPage {

    WebDriver driver;

    public LoginHRPage(WebDriver driver) {
        this.driver= driver;
    }

    private By username = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private  By Login_Button = By.xpath("//button[@type='submit']");

    public void  loginToHRCreds(String user, String pwd){
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(Login_Button).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }





}
