package org.example.tests.saucedemotests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import org.example.pageobjects.ProductsPage;
import org.example.tests.BaseTest;

import static com.codeborne.selenide.Selenide.page;


public class SortingTest extends BaseTest {

    private final ProductsPage productsPage = page(ProductsPage.class);

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void sortingAscendingShouldBePossible() {

        //Given
        loginPage.loginAsValidUser();

        //When
        productsPage.selectSortingType("Name (Z to A)");

        //Then
        productsPage.productsShouldBeSortedDesc();
    }
}
