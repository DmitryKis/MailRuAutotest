package ru.mailauto.mailruautotest.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllMailListPage {

    protected WebDriver driver;

    @FindBy(xpath = "//a[@title='Написать письмо']")
    public WebElement runToCreateMailButton;

    public AllMailListPage(WebDriver driver) {
        driver.switchTo().defaultContent();
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CreateMailPage clickRunToCreateButton() {
        try {
            runToCreateMailButton.click();
        } catch (NoSuchElementException e) {
            Assertions.fail("Неверные учётные данные. Ошибка авторизации.");
        }
        return new CreateMailPage(driver);
    }

}
