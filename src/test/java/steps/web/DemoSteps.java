package steps.web;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.DemoPage;


public class DemoSteps {
    DemoPage demoPage;

    @Given("^user launch google search engine$")
    public void userLaunchGoogleSearchEngine() {
        demoPage.navigateToUrl();
    }

    @When("^user redirected to google page$")
    public void userRedirectedToGooglePage() {
        demoPage.verifyGmailButton();
    }

    @Then("^verify the title of google page$")
    public void verifyTheTitleOfGooglePage() {
        demoPage.verifyGooleTitleOfGooglePage();
    }

    @When("^user type \"([^\"]*)\" in search field$")
    public void userTypeInSearchField(String searchText) {
     demoPage.searchText(searchText);
    }

    @Then("^user can see the \"([^\"]*)\" result in list$")
    public void userCanSeeTheResultInList(String searchResult)  {
    demoPage.verifySearchResult(searchResult);
    }

    @Then("^verify the menu list in footer$")
    public void verifyTheMenuListInFooter() {
     demoPage.verifyFooterMenuList();
    }
}
