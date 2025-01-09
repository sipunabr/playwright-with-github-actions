package org.learning.steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.learning.base.PlaywrightManager;
import org.testng.Assert;

public class PlaywrightSteps {

    private final Page page = PlaywrightManager.getPage();

    @Given("I navigate to {string}")
    public void iNavigateTo(String url) {
        page.navigate(url);
    }

    @Then("the page title should be {string}")
    public void thePageTitleShouldBe(String expectedTitle) {
        String actualTitle = page.title();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch!");
    }
}
