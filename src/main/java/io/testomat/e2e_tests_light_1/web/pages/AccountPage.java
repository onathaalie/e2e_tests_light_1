package io.testomat.e2e_tests_light_1.web.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage {

    public AccountPage navigateToAccountPage() {
        $("#user-menu-button").click();
        $("[href=\"/account\"]").click();
        return this;
    }

    public AccountPage openThemeDropdown() {
        $("#user_theme").click();
        return this;
    }

    public AccountPage verifyThatLightThemeIsSelected() {
        $("[value=\"light\"]").shouldBe(Condition.selected);
        return this;
    }

    public AccountPage changeThemeToDark() {
        $("[value=\"dark\"]").shouldNotBe(Condition.selected).click();
        $("[value=\"Save\"]").click();
        return this;
    }

    public AccountPage saveChangesOfUserAccountUpdate() {
        $("#user_theme").click();
        return this;
    }

    public AccountPage verifyThatDarkThemeIsSelected() {
        $("[value=\"dark\"]").shouldBe(Condition.selected);
        return this;
    }

}
