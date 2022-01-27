package com.mgubin.mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    public WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"passp-field-login\"]")
    private WebElement loginField;
    @FindBy(xpath = "//*[@id=\"passp:sign-in\"]")
    private WebElement loginBtn;

    public void inputLogin(String login)
    {
        loginField.sendKeys(login);
    }
    public void clickLoginBtn()
    {
        loginBtn.click();
    }
}

