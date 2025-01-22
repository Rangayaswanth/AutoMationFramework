package com.yaswanth.pages.pageObjectModel.vwo;

import com.yaswanth.Base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends CommonToAllPage {
    WebDriver driver;

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }


    By UserNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");


    public String loggedInUserName(){
        visibilityOfElement(UserNameOnDashboard);
        return getText(UserNameOnDashboard);


    }









}
