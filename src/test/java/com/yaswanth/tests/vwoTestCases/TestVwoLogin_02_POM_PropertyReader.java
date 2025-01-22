package com.yaswanth.tests.vwoTestCases;

import com.yaswanth.pages.pageObjectModel.vwo.DashBoardPage;
import com.yaswanth.pages.pageObjectModel.vwo.LoginPage;
import com.yaswanth.utils.PropertiesReader;
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

import static org.assertj.core.api.Assertions.assertThat;


public class TestVwoLogin_02_POM_PropertyReader {

    @Test
    @Owner("Yaswanth")
    public void testloginNegativeVWO(){
        WebDriver driver = new EdgeDriver();
        LoginPage loginPage_VWO = new LoginPage(driver);
        String error_msg=loginPage_VWO.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));


    assertThat(error_msg).isNotBlank().isNotEmpty();
    Assert.assertEquals(error_msg,PropertiesReader.readKey("error_msg"));

    }
    @Test
    public void testLoginPositiveVWO(){
        WebDriver driver = new EdgeDriver();


        LoginPage loginPage_VWO = new LoginPage(driver);
        loginPage_VWO.loginToVWOLoginvalidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-qa='lufexuloga']")));

        String usernameLoggedIn = dashBoardPage.loggedInUserName();
        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));

    }













}
