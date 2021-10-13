package net.volodin.pages;

import net.volodin.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage {

    @FindBy(xpath = "//div[@class='inventory_details_desc_container']/button")
    public WebElement addButton;

    @FindBy(className = "shopping_cart_link")
    public WebElement shoppingCart;

    public InventoryItemPage() {
        PageFactory.initElements(BaseClass.getDriver(), this);
    }
}
