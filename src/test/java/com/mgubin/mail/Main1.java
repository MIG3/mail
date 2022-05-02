package com.mgubin.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main1
{

    public static void main(String[] args)
    {
        // Если ошибка при запуске из-за старой версии драйвера файрфокса, скачать по ссылке и положить в папку по указанному пути ниже. Комментарий снять тогда.
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\mgubin\\Downloads\\geckodriver.exe");

        String email = "guard1an33";
        String password = "ThKaw80n4c";

        // Создаем экземпляр WebDriver
        // Следует отметить, что скрипт работает с интерфейсом,
        // а не с реализацией.
        WebDriver driver = new FirefoxDriver();
        WebElement ch, ch1, temp;
        //driver.get("http://www.mail.ru");
        driver.get("https://mail.yandex.ru");

        driver.findElement(By.xpath("//div[@class=\"HeadBanner-ButtonsWrapper\"]//a[2]")).click(); // вот так надо делать, когда нет id

        driver.findElement(By.xpath("//*[@id=\"passp-field-login\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"passp:sign-in\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"passp-field-passwd\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"passp:sign-in\"]")).click();
        //driver.findElement(By.xpath("//*[@title=\"Отметить как прочитанное\"]")).click();
        //driver.findElement(By.xpath("//*[@id=\"nb-checkbox_44\"]")).click();

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

        // Получаю количество непрочитанных писем в папке входящие
        WebElement countNotReadMails = driver.findElement(By.cssSelector(".mail-NestedList-Item-Info-Link-Text"));
        System.out.println("Количество непрочитанных в папке входящие: " + countNotReadMails.getText());

        String cm = countNotReadMails.getText();
        List<WebElement> mailsBlockList = driver.findElements(By.xpath(".//div[@class='ns-view-container-desc mail-MessagesList js-messages-list']//.//div[@class='mail-MessageSnippet-Wrapper']/a[1]//span[2]/span/span[1]"));
        System.out.println("Всего писем в папке входящие: " + mailsBlockList.size());
//        driver.findElement(By.xpath(".//div[@class='mail-MessageSnippet-Wrapper']/a[1]")).click();
        int i = Integer.parseInt(cm);
            for (WebElement we: mailsBlockList)
            {
                if (i > 0)
                {
                    we.click();
                    i--;
                }
            }


//        ch = driver.findElement(By.cssSelector(".ns-view-messages-item-wrap")); // хм, так открывается письмо
//        ch.click();


        // Переход в рассылки в левом меню. Подряд не работает. только один из двух кликов.
//        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//        ch1 = driver.findElement(By.cssSelector(".mail-Tabs-Item_news > span:nth-child(2)"));
//        ch1.click();


        // Закрываем браузер
        //driver.close();
    }
}
