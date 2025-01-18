package com.yaswanth.tests.vwoTestCases;

import com.yaswanth.pages.pageObjectModel.vwo.DashBoardPage;
import com.yaswanth.pages.pageObjectModel.vwo.LoginPage;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;



public class TestVwoLogin_POM {

    @Test
    @Owner("Yaswanth")
    public void testloginNegativeVWO(){
        WebDriver driver = new EdgeDriver();
        LoginPage loginPage_VWO = new LoginPage(driver);
        String error_msg=loginPage_VWO.loginToVWOLoginInvalidCreds("admin","123");


    assertThat(error_msg).isNotBlank().isNotEmpty();
    Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");

    }
    @Test
    public void testLoginPositiveVWO(){
        WebDriver driver = new EdgeDriver();


        LoginPage loginPage_VWO = new LoginPage(driver);
        loginPage_VWO.loginToVWOLoginvalidCreds("contact+aug@thetestingacademy.com","TtxkgQ!s$rJBk85");

        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-qa='lufexuloga']")));

        String usernameLoggedIn = dashBoardPage.loggedInUserName();
        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,"Aman");

    }













}
