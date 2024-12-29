package io.testomat.e2e_tests_light_1.web.pages;

import com.codeborne.selenide.*;
import org.jspecify.annotations.NonNull;

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

}
