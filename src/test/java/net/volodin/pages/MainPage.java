package net.volodin.pages;

import net.volodin.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(className = "app_logo")
    public WebElement appLogo;

    public MainPage() {
        PageFactory.initElements(BaseClass.getDriver(), this);
    }
}
