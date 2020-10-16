package com.automation.pages;

import com.automation.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {

    private final String BASE_URL = "http://flibusta.is/";
    private final By loggedInUserLocator = By.xpath("//*[@id='block-user-1']/div/h2");
    @FindBy(xpath = "//*[@id='edit-name']")
    private WebElement userNameInput;
    @FindBy(xpath = "//*[@id='edit-pass']")
    private WebElement passwordInput;
    @FindBy(xpath = "//*[@id='edit-submit']")
    private WebElement submitLoginButton;
    @FindBy(xpath = "//input[@name='ask']")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@value='искать!']")
    private WebElement searchButton;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public String getLoggedInUserName() {
        WebElement linkLoggedInUser = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(loggedInUserLocator));
        return linkLoggedInUser.getText();
    }

    public MainPage login(User user) {
        userNameInput.sendKeys(user.getUsername());
        passwordInput.sendKeys(user.getPassword());
        submitLoginButton.click();
        return this;
    }

    public SearchResultsPage searchForBook(String bookName) {
        searchInput.sendKeys(bookName);
        searchButton.click();

        return new SearchResultsPage(driver);
    }

}
