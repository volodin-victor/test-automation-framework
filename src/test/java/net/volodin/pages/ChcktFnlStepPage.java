package net.volodin.pages;

import net.volodin.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ChcktFnlStepPage {

    @FindBy(className ="inventory_item_name")
    public WebElement itemName;

    public ChcktFnlStepPage() {
        PageFactory.initElements(BaseClass.getDriver(), this);
    }
}
