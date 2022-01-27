package com.mgubin.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MailPage
{
    public WebDriver driver;

    public MailPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "div.ns-view-messages-item-wrap:nth-child(1)")
    private WebElement incomingEmails;

    @FindBy(css = ".mail-NestedList-Item-Info-Link-Text")
    private WebElement countNotReadMails;
    @FindBy(css = ".mail-Tabs-Item_relevant > span:nth-child(2)")
    private WebElement inbox;

    public void incomingClick()
    {
        incomingEmails.click();
        ;
    }

    // нажатие на кнопку "входящие в боковом меню"
    public void inboxClick()
    {
        inbox.click();
    }

    public String count()
    {
        String countMails = countNotReadMails.getText();
        return countMails;
    }


}