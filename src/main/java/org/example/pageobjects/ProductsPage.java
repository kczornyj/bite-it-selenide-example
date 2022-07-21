package org.example.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.util.Comparator.reverseOrder;

public class ProductsPage {

    private final SelenideElement sortSelectList = $(".product_sort_container");
    private final ElementsCollection products = $$(".inventory_item");
    private final SelenideElement addBackpackToCartButton = $("#add-to-cart-sauce-labs-backpack");
    private final SelenideElement addBikeLightToCartButton = $("#add-to-cart-sauce-labs-bike-light");
    private final SelenideElement cartButton = $(".shopping_cart_link");
    private final SelenideElement shoppingCartItemsAmount = $(".shopping_cart_badge").as("Ilosc przedmiotow w koszyku");

    @Step
    public void selectSortingType(String sortingType) {
        sortSelectList.selectOption(sortingType);
    }

    @Step
    public void productsShouldBeSortedDesc() {
        List<String> sorted = products.texts().stream().sorted(reverseOrder()).collect(Collectors.toList());
        products.shouldHave(exactTexts(sorted));
    }

    @Step
    public void clickCartButton() {
        cartButton.click();
    }

    @Step
    public void amountOfItemsInCartShouldBe(String amountOfItemsInCart) {
        shoppingCartItemsAmount.shouldHave(text(amountOfItemsInCart));
    }

    @Step
    public void clickAddBackpackToCartButton() {
        addBackpackToCartButton.click();
    }

    @Step
    public void clickAddBikeLightToCartButton() {
        addBikeLightToCartButton.click();
    }
}
