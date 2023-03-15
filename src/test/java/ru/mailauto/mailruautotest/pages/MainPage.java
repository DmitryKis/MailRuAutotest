package ru.mailauto.mailruautotest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://mail.ru/
public class MainPage {

    protected WebDriver driver;

    @FindBy(css = "[data-testid = 'enter-mail-primary']")
    public WebElement loginButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoginFrame clickLoginButton() {
        loginButton.click();
        return new LoginFrame(driver);
    }
}
