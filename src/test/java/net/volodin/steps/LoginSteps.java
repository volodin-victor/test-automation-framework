package net.volodin.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.volodin.utils.CommonMethods;
import net.volodin.utils.ConfigsReader;
import org.junit.Assert;

public class LoginSteps extends CommonMethods {
    @When("User enters valid username")
    public void user_enters_valid_username() {
        sendText(loginPage.userName, ConfigsReader.getProperty("username"));
    }

    @When("User enters valid password")
    public void user_enters_valid_password() {
        sendText(loginPage.password, ConfigsReader.getProperty("password"));
    }

    @When("Click on login button")
    public void click_on_login_button() {
        click(loginPage.loginBtn);
    }

    @Then("I validate that user is logged in")
    public void i_validate_that_user_is_logged_in() {
        Assert.assertTrue(mainPage.appLogo.isDisplayed());
    }

    @When("User leaves password empty")
    public void user_leaves_password_empty() {
        sendText(loginPage.password, "");
    }

    @Then("I validate that {string} message is displayed")
    public void i_validate_that_message_is_displayed(String ExpectedMessage) {
        String actualMessage = loginPage.errorMsg.getText();
        Assert.assertEquals(ExpectedMessage,actualMessage);
    }

    @When("User enters invalid username as {string}")
    public void user_enters_invalid_username_as(String username) {
        sendText(loginPage.userName, username);
    }

    @When("User enters valid password as {string}")
    public void user_enters_valid_password_as(String password) {
        sendText(loginPage.password, password);
    }
}
