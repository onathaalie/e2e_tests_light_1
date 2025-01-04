package io.testomat.e2e_tests_light_1.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AnalyticsPage {

    //my personal methods

    public void navigateToAnalyticsPage() {
        $("#content-desktop .current +a +a").click();
        $("#content-desktop h2").shouldBe(Condition.visible);
    }

    public void openProjectsFilter() {
        $("button[onclick=\"toggleModal('projectsSelectModal')\"]\n").click();
    }

    public void clickOnSelectAllFilterOption() {
        $("#projectsSelectModal a").click();
    }

    public void applyProjectsFilter() {
        $("#projectsSelectModal button[type=\"submit\"]").click();
    }

    public void verifyThatFilterOptionIsSelected() {
        openProjectsFilter();
        SelenideElement booksAndMoviesFilter = $("#projectsSelectModal [value=\"books-movies\"]").shouldBe(Condition.checked);
    }

    //my personal methods




}
