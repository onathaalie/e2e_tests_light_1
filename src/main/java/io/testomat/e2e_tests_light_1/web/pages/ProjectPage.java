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

    // my methods

    public ProjectPage openSettingsOfTheFreeProject() {
        $("[class=\"mainnav-menu-body\"] ul li:nth-of-type(10)").click();
        return this;
    }

    public ProjectPage navigateToProjectInfoSettings() {
        $("[class=\"subnav-menu-list-wrapper\"] ul li:nth-of-type(1)").click();
        return this;
    }

    public ProjectPage renameExistingProjectInFreeProjects(String newProjectName) {
        $("#project-title").shouldNotBe(Condition.empty).setValue(newProjectName);
        return this;
    }

    public ProjectPage saveChangesOfProjectInfoInFreeProjects() {
        $("button.primary-btn.btn-text-and-icon.btn-lg").click();
        return this;
    }

    public ProjectPage verifyThatProjectNameIsChanged(String newProjectName) {
        $("#project-title").shouldHave(Condition.value(newProjectName));
        return this;
    }

    // my methods


}
