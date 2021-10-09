package net.volodin.testbase;

import net.volodin.pages.LoginPage;
import net.volodin.pages.MainPage;

/**
 * Method performs initialization
 */
public class PageInitializer extends BaseClass {
    public static LoginPage loginPage;
    public static MainPage mainPage;

    public static void initialize() {
        loginPage = new LoginPage();
        mainPage = new MainPage();
    }
}
