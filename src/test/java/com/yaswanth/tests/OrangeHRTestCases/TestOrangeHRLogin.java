package com.yaswanth.tests.OrangeHRTestCases;

import com.yaswanth.pages.pageObjectModel.OrangeHR.EmployeeListHomePage;
import com.yaswanth.pages.pageObjectModel.OrangeHR.LoginHRPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;
import static org.assertj.core.api.Assertions.assertThat;



public class TestOrangeHRLogin {
    @Test
    public void testOrangeHR_POM(){
        WebDriver driver = new EdgeDriver();
        LoginHRPage loginHRPage = new LoginHRPage(driver);
        loginHRPage.loginToHRCreds("Admin","Hacker@4321");


        EmployeeListHomePage employeeListHomePage = new EmployeeListHomePage(driver);
        String loggedInUserName = employeeListHomePage.loggedUserName();

        assertThat(loggedInUserName).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(loggedInUserName,"PIM");

    }











}
