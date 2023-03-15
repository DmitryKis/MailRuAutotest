package ru.mailauto.mailruautotest.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateMailPage {

    protected WebDriver driver;

    @FindBy(xpath = "//input[@class='container--H9L5q size_s_compressed--2c-eV']")
    public WebElement sendToTextField;

    @FindBy(name = "Subject")
    public WebElement subjectTextField;

    @FindBy(xpath = "//div[@contenteditable='true']/div")
    public WebElement messageBodyArea;

    @FindBy(xpath = "//button[@data-test-id='send']")
    public WebElement sendButton;

    public CreateMailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://e.mail.ru/inbox/?app_id_mytracker="));
        this.driver = driver;
    }

    public CreateMailPage enterMessageBody(String content) {
        messageBodyArea.sendKeys(content);
        return this;
    }

    public CreateMailPage enterSendToField(String destination) {
        sendToTextField.sendKeys(destination);
        return this;
    }

    public CreateMailPage enterSubject(String subject) {
        subjectTextField.sendKeys(subject);
        return this;
    }

    public void clickSendButton() {
        sendButton.click();
        // Необходимость, без явного засыпания потока сообщение не отправляется
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.err.println("Ошибка ожидания потока");
            e.printStackTrace();
        }
    }

}
