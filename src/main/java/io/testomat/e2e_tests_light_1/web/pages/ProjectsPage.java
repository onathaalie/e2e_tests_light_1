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

    public void isLoaded() {
        searchInput.shouldBe(Condition.visible);
    }

    public void signInSuccess() {
        $("#container .common-flash-success").shouldBe(Condition.visible);
    }

    public void searchForProject(String targetProjectName) {
        $("#search").setValue(targetProjectName);
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

    //my personal methods

    public void userCanSelectFreeProjectsInDropdown() {
        $("#content-desktop #company_id").click();
        SelenideElement firstOption = $("#content-desktop #company_id option:nth-of-type(1)").shouldHave(Condition.text("Free Projects"));
        firstOption.shouldNotBe(Condition.selected);
        firstOption.click();
        firstOption.shouldBe(Condition.selected);
    }

    public void clickOnCreateProjectButton() {
        $("#container [href=\"/projects/new\"]").click();
    }

    public void enterNameForANewProject() {
        $("[name=\"project[title]\"]").setValue("My test project");
    }

    public void submitAndVerifyNewProject() {
        $("[name=\"commit\"]").click();
        $("#ember41 h1").shouldBe(Condition.visible);
    }

    public void openTheFirstProjectInFreeProjects() {
        $("[title=\"my project\"] >div").click();
        $("#ember40").shouldBe(Condition.visible);
    }

    public void createTheFirstTestSuite() {
        $("#item-title").setValue("My first Test Suite");
        $("button[class=\"primary-btn btn-text-and-icon btn-lg\"]").click();
        $("#ember82 span").shouldHave(Condition.text("My first Test Suite"));
    }

    //my personal methods



}
