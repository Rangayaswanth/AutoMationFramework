package com.yaswanth.driver;

import com.yaswanth.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public  static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }


    public static void init(){
        String browser = PropertiesReader.readKey("browser");
        browser = browser.toLowerCase();
        if(driver==null){
            switch (browser){
                case "edge" :
                    EdgeOptions edgeoptions = new EdgeOptions();
                    edgeoptions.addArguments("--start-maximized");
                    edgeoptions.addArguments("--guest");
                    driver = new EdgeDriver(edgeoptions);
                    break;
                case "chrome" :
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox" :
                    FirefoxOptions firefoxOptions  = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");
                    firefoxOptions.addArguments("--guest");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                default:
                    System.out.println("Not browser found!!");
            }
        }
    }

    public static void down(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
