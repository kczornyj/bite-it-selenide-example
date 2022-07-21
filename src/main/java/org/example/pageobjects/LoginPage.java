package org.example.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement usernameInput = $("#user-name");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement loginButton = $("#login-button");
    private final SelenideElement errorMessage = $x(".//h3[@data-test='error']");

    @Step
    public void errorMessageShouldBe(String expectedText) {
        errorMessage.shouldHave(exactText("Epic sadface: " + expectedText));
    }

    @Step
    public void loginAsUser(String username, String password) {
        enterLogin(username);
        enterPassword(password);
        clickLoginButton();
    }

    @Step
    public void loginAsValidUser() {
        loginAsUser("standard_user", "secret_sauce");
    }

    private void enterLogin(String login) {
        usernameInput.setValue(login);
    }

    private void enterPassword(String password) {
        passwordInput.setValue(password);
    }

    private void clickLoginButton() {
        loginButton.click();
    }
}
