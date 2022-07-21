package org.example.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutStepTwoPage {

    private final SelenideElement itemTotalLabel = $(".summary_subtotal_label");
    private final SelenideElement taxTotalLabel = $(".summary_tax_label");
    private final SelenideElement totalLabel = $(".summary_total_label");
    private final SelenideElement finishButton = $("#finish");

    @Step
    public void clickFinishButton() {
        finishButton.click();
    }

    @Step
    public void itemTotalPriceShouldBe(String expectedPrice){
        itemTotalLabel.shouldHave(text(expectedPrice));
    }

    @Step
    public void taxTotalPriceShouldBe(String expectedPrice){
        taxTotalLabel.shouldHave(text(expectedPrice));
    }

    @Step
    public void totalPriceShouldBe(String expectedPrice){
        totalLabel.shouldHave(text(expectedPrice));
    }
}
