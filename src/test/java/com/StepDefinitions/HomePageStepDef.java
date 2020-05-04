package com.StepDefinitions;

import com.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import cucumber.api.CucumberOptions.*;
//import cucumber.api.java.*;


public class HomePageStepDef {

    HomePage homePage = new HomePage();
    @Given("Open the Home Page")
    public void open_the_Home_Page() throws InterruptedException {
             homePage.openBrowser();
    }

    @When("The landing page is verified")
    public void the_links_should_be_available_on_the_Home_Page() throws InterruptedException {
    homePage.verifyHomePage();
    }

    @Then("Search for Links: Browse by Make, Browse by Style, Advanced Search")
    public void search_for_Links_Browse_by_Make_Browse_by_Style_Advanced_Search() {
    homePage.verifyLinks();
    }


    @When("Fill the Advanced Search form")
    public void fillTheAdvancedSearchForm() {
        homePage.fillTheAdvancedSearchForm();
    }

    @Then("verify the count of Results")
    public void verifyTheCountOfResults() {
        homePage.getTheListOfResults();
    }

}
