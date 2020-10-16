package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
    private final By foundBooksSection = By.xpath("//*[contains(text(), 'Найденные книги')]");
    private WebDriver driver;
    @FindBy(xpath = "//*[contains(text(), 'Преступление')]")
    private WebElement foundBook;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchResultsPage AssureBooksAreFound() {
        WebElement foundBooks = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(foundBooksSection));
        return this;
    }

    public BookPage navigateToBookPage() {
        foundBook.click();
        return new BookPage(driver);
    }
}
