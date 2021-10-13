package net.volodin.pages;

import net.volodin.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChcktStepOnePage {

    @FindBy(id = "first-name")
    public WebElement firstNameField;

    @FindBy(id = "last-name")
    public WebElement lastNameField;

    @FindBy(xpath = "//input[@name='postalCode']")
    public WebElement zipCode;

    @FindBy(xpath = "//div[@class='checkout_buttons']/input[@id='continue']")
    public WebElement continueBtn;

    public ChcktStepOnePage() {
        PageFactory.initElements(BaseClass.getDriver(), this);
    }
}
