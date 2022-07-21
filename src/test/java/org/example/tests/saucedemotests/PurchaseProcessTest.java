package org.example.tests.saucedemotests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.example.pageobjects.CartPage;
import org.example.pageobjects.CheckoutCompletePage;
import org.example.pageobjects.CheckoutPage;
import org.example.pageobjects.CheckoutStepTwoPage;
import org.example.pageobjects.ProductsPage;
import org.example.tests.BaseTest;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.page;

public class PurchaseProcessTest extends BaseTest {

    private final ProductsPage productsPage = page(ProductsPage.class);
    private final CartPage cartPage = page(CartPage.class);
    private final CheckoutPage checkoutPage = page(CheckoutPage.class);
    private final CheckoutStepTwoPage checkoutStepTwoPage = page(CheckoutStepTwoPage.class);
    private final CheckoutCompletePage checkoutCompletePage = page(CheckoutCompletePage.class);

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void loginWithInvalidPasswordShouldDisplayError() {

        //Given
        loginPage.loginAsUser("standard_user", "secret_sauce");

        //When
        productsPage.clickAddBikeLightToCartButton();
        productsPage.clickAddBackpackToCartButton();
        productsPage.clickCartButton();

        //And

        cartPage.clickCheckoutButton();

        //And
        checkoutPage.enterFirstName("TestName");
        checkoutPage.enterLastName("TestSurname");
        checkoutPage.enterZipCode("PL2 EN1");
        checkoutPage.clickContinueButton();

        //And
        checkoutStepTwoPage.itemTotalPriceShouldBe("$39.98");
        checkoutStepTwoPage.taxTotalPriceShouldBe("$3.20");
        checkoutStepTwoPage.totalPriceShouldBe("$43.18");
        checkoutStepTwoPage.clickFinishButton();

        //Then
        checkoutCompletePage.thankYouMessageShouldBeDisplayed();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void amountOfItemsInCartShouldBeDisplayedProperly() {

        //Given
        loginPage.loginAsUser("standard_user", "secret_sauce");

        //When
        productsPage.clickAddBikeLightToCartButton();
        productsPage.clickAddBackpackToCartButton();

        //Then
        productsPage.amountOfItemsInCartShouldBe("1");
    }
}
