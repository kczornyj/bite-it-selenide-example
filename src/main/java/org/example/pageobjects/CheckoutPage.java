package org.example.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {

    private final SelenideElement firstNameInput = $("#first-name");
    private final SelenideElement lastNameInput = $("#last-name");
    private final SelenideElement zipCodeInput = $("#postal-code");
    private final SelenideElement continueButton = $("#continue");

    @Step
    public void enterFirstName(String firstName){
        firstNameInput.setValue(firstName);
    }

    @Step
    public void enterLastName(String lastName){
        lastNameInput.setValue(lastName);
    }

    @Step
    public void enterZipCode(String zipCode){
        zipCodeInput.setValue(zipCode);
    }

    @Step
    public void clickContinueButton() {
        continueButton.click();
    }
}
