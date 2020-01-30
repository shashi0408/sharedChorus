package com.All.Chorus.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ChorusPage {
    public ChorusPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

@FindBy(how= How.XPATH,using=".//h2[@class='banner__title']")
public WebElement mainHeader;

@FindBy(how=How.XPATH,using = ".//input[@id='wivolo-search-input']")
public WebElement searchInput;

@FindBy(how=How.XPATH,using = ".//div[@class='location-details-heading']")
public WebElement verifyresultHeader;



}
