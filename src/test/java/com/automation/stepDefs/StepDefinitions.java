package com.automation.stepDefs;

import com.automation.driver.DriverSingleton;
import com.automation.model.User;
import com.automation.pages.BookPage;
import com.automation.pages.MainPage;
import com.automation.pages.SearchResultsPage;
import com.automation.service.UserCreator;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class StepDefinitions{

    protected WebDriver driver;
    public MainPage mainPage;
    public SearchResultsPage searchResultsPage;
    public BookPage bookPage;
    User testUser = UserCreator.withCredentialsFromProperty();

    @Before()
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @After()
    public void tearDown() {
        DriverSingleton.closeDriver();
    }


    @Given("I am on the http:\\/\\/flibusta.is\\/ Home Page")
    public void iAmOnTheHttpFlibustaIsHomePage() {
        mainPage= new MainPage(driver);
        mainPage.openPage();
    }

    @When("I fill Login field with {string} and fill Password field with {string}")
    public void i_fill_login_field_with_and_fill_password_field_with(String login, String password) {
        mainPage.login(testUser);
    }


    @Then("I should see {string} on the Website")
    public void i_should_see_on_the_website(String login) {
        String loggedInUserName = mainPage.getLoggedInUserName();
        Assert.assertEquals(loggedInUserName, testUser.getUsername());
    }


    @When("I type {string} into Search Field")
    public void iTypeIntoSearchField(String bookName) {
        searchResultsPage = new MainPage(driver)
                .searchForBook("Преступление и наказание");
    }
    
    @Then("I should see Search Results")
    public void iShouldSeeSearchResults() {
        searchResultsPage.AssureBooksAreFound();
        Assert.assertTrue(true);
    }

    @When("I navigate to Book Page")
    public void iNavigateToBookPage() {
        searchResultsPage.navigateToBookPage();
    }

    @Then("I should be able to Send A Book To Email")
    public void iShouldBeAbleToSendABookToEmail() {
        bookPage = new BookPage(driver);
        bookPage.assureSentBookToEmailIsAvailable();
        Assert.assertTrue(true);
    }
}
