package com.All.Chorus.StepDefs;

import com.All.Chorus.Common.Browser;
import com.All.Chorus.Common.Hooks;
import com.All.Chorus.Pages.ChorusPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;


public class ChorusService {
  WebDriver driver;
  Properties prop;
  Scenario scenario;
  public ChorusPage chorusPage;
  Browser browser;

  Hooks hooks = new Hooks();
public ChorusService(Browser browser){this.browser=browser;}
  @Before
    public void Before(Scenario scenario){this.scenario=scenario;}


    @Given("^Go to the Chorus Service$")
    public void goToTheChorusService() {
        driver = browser.getDriver();
        prop = browser.getProp();
        chorusPage = browser.getchorusPage();
        driver.get("https://www.chorus.co.nz/broadband-map");
        scenario.write("Validate user reached to page");
        hooks.explicitWait(driver,30, chorusPage.mainHeader);
       Assert.assertTrue("Validation fails on header page",chorusPage.mainHeader.getText().contains("Broadband availability map"));

    }

    @When("^User want to check service on particular address (.*)$")
    public void userWantToCheckServiceOnParticularAddressAddress(String address) throws InterruptedException {

    scenario.write("User searched for address"+address);
        chorusPage.searchInput.sendKeys(address);
        Thread.sleep(3000);
        List<WebElement> inputResults = browser.getDriver().findElements(By.xpath(".//li[@class='ui-menu-item']"));
        if(inputResults.size()>0){
            inputResults.get(0).click();
        }
        else{
            scenario.write("No Results available for address"+address);
        }

    }


    @Then("^User verifies the possible services and prints the results$")
    public void userVerifiesThePossibleServices() throws InterruptedException {
        Thread.sleep(9000);
        List<WebElement> services = browser.getDriver().findElements(By.xpath(".//div[@id='location-details-now']//li"));

        if(services.size()>0){
            Assert.assertTrue("No Service Found",services.size()>0);
            scenario.write("Number of services found,check the results:- "+services.size());
            for (WebElement result:services) {

                scenario.write("Service Found.."+result.getText());
            }


        }
        else{
            scenario.write("No Results available for address");
        }

    }

    @After
    public void Before(){
    browser.getDriver().quit();
    }





}
