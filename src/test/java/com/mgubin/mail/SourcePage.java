package com.mgubin.mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SourcePage
{
    public WebDriver driver;
    public SourcePage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//div[@class=\"HeadBanner-ButtonsWrapper\"]//a[2]")
    private WebElement InputBtn;

    public void clickLoginBtn()
    {
        InputBtn.click();
    }
}

