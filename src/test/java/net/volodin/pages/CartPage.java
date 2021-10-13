package net.volodin.pages;

import net.volodin.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    @FindBy(xpath = "//div[@id='cart_contents_container']//button[@id='checkout']")
    public WebElement checkoutBtn;

    public CartPage() {
        PageFactory.initElements(BaseClass.getDriver(), this);
    }
}
