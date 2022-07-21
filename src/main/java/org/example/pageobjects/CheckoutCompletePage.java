package org.example.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage {

    private final SelenideElement thankYouMessage = $("h2");

    @Step
    public void thankYouMessageShouldBeDisplayed() {
        thankYouMessage.shouldHave(text("THANK YOU FOR YOUR ORDER"));
    }
}
