package com.mgubin.mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswPage
{
    public WebDriver driver;
    public PasswPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"passp-field-passwd\"]")
    private WebElement passwField;
    @FindBy(xpath = "//*[@id=\"passp:sign-in\"]")
    private WebElement passwBtn;

    public void inputPasswd(String passwd)
    {
        passwField.sendKeys(passwd);
    }
    public void clickPasswBtn()
    {
        passwBtn.click();
    }
}

