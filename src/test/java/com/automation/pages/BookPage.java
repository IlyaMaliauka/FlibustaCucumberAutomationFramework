package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookPage {
    private final By sendBookToEmailButton = By.xpath("//*[text()='(mail)']");
    private WebDriver driver;

    public BookPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BookPage assureSentBookToEmailIsAvailable() {
        WebElement sentToEmailButton = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(sendBookToEmailButton));
        return this;
    }

}
