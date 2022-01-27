package com.mgubin.mail;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.И;

import com.mgubin.mail.AuthTest;
import io.cucumber.java.ru.То;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestSteps
{
    public static LoginPage loginPage;
    public static PasswPage passwPage;
    public static MailPage mailPage;
    public static SourcePage inputPage;
    public static WebDriver driver;

    @Если("^авторизация в почте успешна")
    public void auth()
    {
        // Получаю количество непрочитанных писем в папке входящие
        String cm = mailPage.count();
        System.out.println("Количество непрочитанных писем в папке входящие: " + cm);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> mailsBlockList = driver.findElements(By.xpath(".//div[@class='ns-view-container-desc mail-MessagesList js-messages-list']//div[@class='mail-MessageSnippet-Wrapper']/a[1]//span[2]/span/span[1]"));
        System.out.println("Всего писем в папке входящие: " + mailsBlockList.size());
        int i = Integer.parseInt(cm);
        for (WebElement we: mailsBlockList)
        {
            if (i > 0)
            {
                we.click();
                i--;
            }
        }
    }

    @Допустим("^выполнен вход на страницу авторизации")
    public static void setup()
    {
        driver = new FirefoxDriver();
        loginPage = new LoginPage(driver);
        passwPage = new PasswPage(driver);
        mailPage = new MailPage(driver);
        inputPage = new SourcePage(driver);

        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://mail.yandex.ru");
        inputPage.clickLoginBtn();
    }
    @И("^произведена авторизация в почте яндекса")
    public static void authorisation()
    {
        loginPage.inputLogin("guard1an33");
        loginPage.clickLoginBtn();
        passwPage.inputPasswd("ThKaw80n4c");
        passwPage.clickPasswBtn();
    }

    @То("^письма отмечены и браузер закрыт")
    public static void Exit()
    {
        driver.quit();
    }

}
