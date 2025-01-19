package io.testomat.e2e_tests_light_1.web.pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPage {

    private SelenideElement searchInput = $("#search");

    public void open() {
        Selenide.open("");
    }

    public ProjectsPage isLoaded() {
        searchInput.shouldBe(Condition.visible);
        return this;
    }

    public void signInSuccess() {
        $("#container .common-flash-success").shouldBe(Condition.visible);
    }

    public ProjectsPage searchForProject(String targetProjectName) {
        $("#search").setValue(targetProjectName);
        return this;
    }

    public void selectProject(String targetProjectName) {
        $(byText(targetProjectName)).click();
    }

    public ElementsCollection countOfProjectsShouldBeEqualTo(int expectedSize) {
        return $$("#grid ul li").filter(Condition.visible).shouldHave(CollectionCondition.size(expectedSize));
    }

    public void countOfTestCasesShouldBeEqualTo(SelenideElement targetProject, int expectedCount) {
        targetProject.shouldHave(Condition.text(expectedCount + " tests"));

        /*String countOfTests = targetProject.$("p").getText();
        Integer actualCountOfTests = parseIntegerFromString(countOfTests);
        Assertions.assertEquals(expectedCount, actualCountOfTests);*/
    }

    public void totalCountOfProjectsIsVisible() {
        $("#container kbd").shouldBe(Condition.visible);
    }

    public String getTotalCountOfTestCases() {
        return $("#container kbd").getText();
    }



    // my methods
    public ProjectsPage selectFreeProjectsInProjectsDropdown() {
        $("[name=\"company[id]\"]").click();
        $("[name=\"company[id]\"] option:first-of-type").shouldNotBe(Condition.selected).click();
        return this;
    }

    public ProjectsPage selectExistingProjectInFreeProjects() {
        $("[href=\"/projects/my-test-project-71bdb/\"] div").click();
        return this;
    }



    // my methods


}
