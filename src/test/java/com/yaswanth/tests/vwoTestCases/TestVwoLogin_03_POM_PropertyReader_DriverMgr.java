package com.yaswanth.tests.vwoTestCases;

import com.yaswanth.Base.CommonToAllPage;
import com.yaswanth.base.CommonToAllTest;
import com.yaswanth.driver.DriverManager;
import com.yaswanth.pages.pageObjectModel.vwo.DashBoardPage;
import com.yaswanth.pages.pageObjectModel.vwo.LoginPage;
import com.yaswanth.utils.PropertiesReader;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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


public class TestVwoLogin_03_POM_PropertyReader_DriverMgr extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVwoLogin_03_POM_PropertyReader_DriverMgr.class);


    @Test
    @Owner("Yaswanth")
    public void testloginNegativeVWO(){
        logger.info("Starting the Testcases Page Object Model");


        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        String error_msg=loginPage_VWO.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        logger.info("End of the testLoginNegativeVWO !");

        assertThat(error_msg).isNotBlank().isNotEmpty();

       Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));

    }
    @Test
    public void testLoginPositiveVWO(){

        logger.info("Starting the Testcases |  Verify that valid creds dashboard page is loaded");



        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        loginPage_VWO.loginToVWOLoginvalidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashBoardPage dashBoardPage = new DashBoardPage(DriverManager.getDriver());
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-qa='lufexuloga']")));

        String usernameLoggedIn = dashBoardPage.loggedInUserName();

        logger.info("End and Asserting testLoginPositiveVWO");

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));

    }













}
