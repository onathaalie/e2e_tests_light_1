package io.testomat.e2e_tests_light_1.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AnalyticsPage {

    //my personal methods

    public AnalyticsPage navigateToAnalyticsPage() {
        $("[href=\"/analytics\"]").click();
        $("#content-desktop h2").shouldBe(Condition.visible);
        return this;
    }

    public AnalyticsPage openProjectsFilter() {
        $("button[onclick=\"toggleModal('projectsSelectModal')\"]").click();
        return this;
    }

    public AnalyticsPage clickOnSelectAllFilterOption() {
        $("#projectsSelectModal a").click();
        return this;
    }

    public AnalyticsPage applyProjectsFilter() {
        $("#projectsSelectModal button[type=\"submit\"]").click();
        return this;
    }

    public AnalyticsPage verifyThatFilterOptionIsSelected() {
        SelenideElement booksAndMoviesFilter = $("#projectsSelectModal [value=\"books-movies\"]").shouldBe(Condition.checked);
        return this;
    }

    //my personal methods




}
