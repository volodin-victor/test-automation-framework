package net.volodin.pages;

import net.volodin.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    @FindBy(className = "app_logo")
    public WebElement appLogo;

    @FindBy(className = "inventory_item_name")
    public List<WebElement> itemList;

    public MainPage() {
        PageFactory.initElements(BaseClass.getDriver(), this);
    }
}
