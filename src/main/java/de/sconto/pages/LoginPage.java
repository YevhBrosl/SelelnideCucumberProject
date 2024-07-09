package de.sconto.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import de.sconto.utils.PropertiesLoader;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public static final String validEmail = PropertiesLoader.loadProperty("valid.email");
    public static final String validPassword = PropertiesLoader.loadProperty("valid.password");

    @FindBy(css = ".existingAccount__headline")
    WebElement loginFormTitle;
    public SelenideElement loginFormTitle() {
        return $(loginFormTitle).should(exist);
    }

    @FindBy(id = "loginEmail")
    WebElement emailInput;

    @FindBy(id = "loginPassword")
    WebElement passwordInput;

    public LoginPage validLoginInput() {
        $(emailInput).val(validEmail);
        $(passwordInput).val(validPassword);
        return Selenide.page(LoginPage.class);
    }

    @FindBy(id = "login-submit")
    WebElement anmeldenButton;

    public HomePage clickOnAnmeldenButton() {
        $(anmeldenButton).click();
        return Selenide.page(HomePage.class);
    }

    public LoginPage invalidLoginInput(DataTable table) {
        List<Map<String,String>> dataTable = table.asMaps();

        String email = dataTable.get(0).get("email");
        String password = dataTable.get(0).get("password");

        enterDataFromTable(email, password);
        return Selenide.page(LoginPage.class);
    }

    private LoginPage enterDataFromTable(String email, String password) {
        $(emailInput).val(email);
        $(passwordInput).val(password);
        return Selenide.page(LoginPage.class);
    }

    @FindBy(id = "loginEmail-error")
    WebElement loginError;

    public SelenideElement errorMessageText(String errorText) {
        return $(loginError).shouldHave(text(errorText));
    }
}
