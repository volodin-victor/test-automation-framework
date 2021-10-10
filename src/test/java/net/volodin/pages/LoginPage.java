package net.volodin.pages;

import net.volodin.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "user-name")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement loginBtn;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMsg;

    public LoginPage() {
        PageFactory.initElements(BaseClass.getDriver(), this);
    }
}
