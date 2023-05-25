package com. selenium;
import cucumber.api.java.en.Given;

public class Step Defination {
    @Given("^User have opened the browser$")
    public void i_have_open_the_browser() throws Throwable {
        System.out.printIn("Opened the browser Successfully");
    }

    @When("User have opened EasyTesting website$")
    public void i_open_EasyTesting_website() throws Throwable {
// Write code here that turns the phrase above into concrete actions
        System.out.printIn("Opened the Login screen Successfully");
    }

    @When("User entered username as \"([^\"]*)\" and password as \"([^\"]*\"$")
    public void i_enter_username_as_and_password_as(String arg1, String arg2) throws Throwable {
        System.out.printin("Enter username as" + argl + "Password as" + arg2);
    }

    @Then("^Login button should exist$")
    public void login_button_should_exits() throws Throwable {
        System.out.printIn("Button pressed Successfully");
    }
}