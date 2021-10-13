package net.volodin.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.volodin.utils.CommonMethods;
import net.volodin.utils.ConfigsReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class CheckoutSteps extends CommonMethods {
    @Given("User is actually successfully logged in")
    public void user_is_actually_successfully_logged_in() {
        sendText(loginPage.userName, ConfigsReader.getProperty("username"));
        sendText(loginPage.password, ConfigsReader.getProperty("password"));
        click(loginPage.loginBtn);
    }

    @When("^I click on the item with name \"([^\"]*)\"$")
    public void i_click_on_the_item_with_name(String itemName) {
        for (WebElement item : mainPage.itemList) {
            if (item.getText().equals(itemName)) {
                click(item);
                break;
            }
        }
    }

    @When("I click on the add to card button")
    public void i_click_on_the_add_to_card_button() {
        click(inventoryItemPage.addButton);
    }

    @When("I click on the shopping cart button")
    public void i_click_on_the_shopping_cart_button() {
        click(inventoryItemPage.shoppingCart);
    }

    @When("I click on the checkout button")
    public void i_click_on_the_checkout_button() {
        click(cartPage.checkoutBtn);
    }

    @When("I enter the the order information as {string}, {string}>, {string}")
    public void i_enter_the_the_order_information_as(String firstName, String lastName, String zipcode) {
        sendText(chcktStepOnePage.firstNameField, firstName);
        sendText(chcktStepOnePage.lastNameField, firstName);
        sendText(chcktStepOnePage.zipCode, zipcode);
    }

    @When("I click on the continue")
    public void i_click_on_the_continue() {
        click(chcktStepOnePage.continueBtn);
    }

    @Then("I verify the item name matches that of {string}")
    public void i_verify_the_item_name_matches_that_of(String itemName) {
        Assert.assertTrue(checkoutFinalStepPage.itemName.isDisplayed());
        Assert.assertEquals(itemName, checkoutFinalStepPage.itemName.getText());
    }

}