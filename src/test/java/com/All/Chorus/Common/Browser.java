package com.All.Chorus.Common;

import com.All.Chorus.Pages.ChorusPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

public class Browser {

    private WebDriver driver;
    private Properties prop;
    private ChorusPage chorusPage;

    @Before
    public void setUp(){
//        FileInputStream f = null;
//        try{ f = new FileInputStream(new File("C:/Workspace/EmiratesAutomationTest/src/test/Resources/com/emirates/flight/Config.properties"));
//
//        }catch(FileNotFoundException e){
//            e.printStackTrace();
//        }

//        prop = new Properties();
//        try{
//            prop.load(f);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
       System.setProperty("webdriver.chrome.driver","src/test/java/com/All/Chorus/Drivers/chromedriver");
       // WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        chorusPage = new ChorusPage(driver);

    }

    public WebDriver getDriver(){
        return driver;
    }

    public Properties getProp(){
        return prop;
    }

   public ChorusPage getchorusPage(){
        return chorusPage;
    }

    @After
    public void tearDown(){
//        driver.quit();
    }

}
