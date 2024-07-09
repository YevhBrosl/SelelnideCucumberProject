package de.sconto.stepDefinitions;

import com.codeborne.selenide.Selenide;
import de.sconto.pages.CustomerAccountPage;
import de.sconto.pages.HomePage;
import de.sconto.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    HomePage home;
    LoginPage login;
    CustomerAccountPage customer;

    @When("User clicks on User icon")
    public void click_on_User_icon() {
        home = Selenide.page(HomePage.class);
        login = home.clickOnLoginIcon();
    }

    @Then("User verifies Login form")
    public void verify_Login_form() {
        login.loginFormTitle();
    }

    @When("User enters valid credentials")
    public void enter_valid_credentials() {
        login.validLoginInput();
    }

    @And("User clicks on Anmelden button")
    public void click_on_Anmelden_button() {
        login.clickOnAnmeldenButton();
    }

    @Then("User verifies user name status")
    public void verify_user_name_status() {
        home.userNameStatus();
    }

    @Then("User verifies user name")
    public void verify_user_name() {
        customer = Selenide.page(CustomerAccountPage.class);
        customer.userName("Bertie Wooster");
    }

    @When("User enters invalid email and valid password")
    public void enter_invalid_email_and_valid_password(DataTable table) {
        login.invalidLoginInput(table);
    }

    @Then("User verifies Error message is displayed")
    public void verify_Error_message() {
        login.errorMessageText("Bitte geben Sie eine gültige E-Mail-Adresse ein");
    }


}
