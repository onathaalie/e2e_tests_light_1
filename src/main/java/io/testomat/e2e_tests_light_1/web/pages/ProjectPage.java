package io.testomat.e2e_tests_light_1.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {
    public void isLoaded(String targetProjectName) {
        $(".first h2").shouldHave(Condition.text(targetProjectName));
        $(".first [href*='/readme']").shouldHave(Condition.text("Readme"));
    }

    public ProjectPage openReadme() {
        $(Selectors.byLinkText("Readme")).click();
        return this;

    }

    public ProjectPage editReadme() {
        $(Selectors.byLinkText("Edit")).click();
        return this;
    }


}
