package ru.mailauto.mailruautotest.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.mailauto.mailruautotest.pages.MainPage;

import java.util.concurrent.TimeUnit;

public class SendMailTest {

    private WebDriver driver;
    private MainPage mainPage;


    /**
     * @param login, password - Данные учётной записи (ТУЗ)
     */
    private String login = "login";
    private String password = "password";

    /**
     * @param email - Почтовый адрес адресанта
     */
    private String email = "kiselev17.00@mail.ru";

    @Test
    public void AuthorizationAndSendMailMessageTest() {
        mainPage.clickLoginButton()
                .enterUsername(login)
                .clickNextButton()
                .enterPassword(password)
                .clickSubmitButton()
                .clickRunToCreateButton()
                .enterMessageBody("Добрый день! Мы проверяем ваше ТЗ")
                .enterSendToField(email)
                .enterSubject("Test")
                .clickSendButton();
    }
    @BeforeEach
    public void setUpDriver() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.get("https://mail.ru/");
        mainPage = new MainPage(driver);
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
