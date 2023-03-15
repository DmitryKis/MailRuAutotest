package ru.mailauto.mailruautotest.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFrame {

    protected WebDriver driver;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@data-test-id='next-button' and @type='submit']")
    public WebElement nextButton;

    @FindBy(xpath = "//button[@data-test-id='submit-button' and @type='submit']")
    public WebElement submitButton;

    public LoginFrame(WebDriver driver) {
        try{
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']")));
        } catch (NoSuchElementException e){
            Assertions.fail("Вспывающее окно авторизации не найдено");
        }
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoginFrame enterUsername(String username) {
        usernameField.sendKeys(username);
        return this;
    }

    public LoginFrame clickNextButton() {
        nextButton.click();
        Assertions.assertNotNull(passwordField);
        return this;
    }

    public LoginFrame enterPassword(String password) {
        try {
            passwordField.sendKeys(password);
        } catch (ElementNotInteractableException e) {
            Assertions.fail("Неверные учётные данные. Логин не зарегистрирован");
        }
        return this;
    }

    public AllMailListPage clickSubmitButton() {
        submitButton.click();
        return new AllMailListPage(driver);
    }
}
