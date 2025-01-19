package io.testomat.e2e_tests_light_1.web.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage {

    public void navigateToAccountPage() {
        $("#user-menu-button").click();
        $("[href=\"/account\"]").click();
    }

    public void openThemeDropdown() {
        $("#user_theme").click();
    }

    public void verifyThatLightThemeIsSelected() {
        $("[value=\"light\"]").shouldBe(Condition.selected);
    }

    public void changeThemeToDark() {
        $("[value=\"dark\"]").shouldNotBe(Condition.selected).click();
        $("[value=\"Save\"]").click();
    }

    public void saveChangesOfUserAccountUpdate() {
        $("#user_theme").click();
    }

    public void verifyThatDarkThemeIsSelected() {
        $("[value=\"dark\"]").shouldBe(Condition.selected);
    }

}
