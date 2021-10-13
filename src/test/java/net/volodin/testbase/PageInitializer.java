package net.volodin.testbase;

import net.volodin.pages.*;

/**
 * Method performs initialization
 */
public class PageInitializer {

    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static CartPage cartPage;
    public static InventoryItemPage inventoryItemPage;
    public static ChcktStepOnePage chcktStepOnePage;
    public static ChcktFnlStepPage checkoutFinalStepPage;

    public static void initialize() {

        loginPage = new LoginPage();
        mainPage = new MainPage();
        cartPage = new CartPage();
        inventoryItemPage = new InventoryItemPage();
        chcktStepOnePage = new ChcktStepOnePage();
        checkoutFinalStepPage = new ChcktFnlStepPage();

    }
}
