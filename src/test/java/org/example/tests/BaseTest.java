package org.example.tests;

import io.qameta.allure.selenide.AllureSelenide;
import org.example.pageobjects.LoginPage;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class BaseTest {

    protected final LoginPage loginPage = page(LoginPage.class);

    @Before
    public void openSauceDemoPage() {
        open("https://www.saucedemo.com/");
    }

    @After
    public void clearBrowser() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @Before
    public void setupAllureReports() {
        addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
    }
}
