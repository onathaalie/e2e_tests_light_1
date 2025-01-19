package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.testomat.e2e_tests_light_1.common.Application;
import io.testomat.e2e_tests_light_1.utils.StringParsers;
import io.testomat.e2e_tests_light_1.web.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.testomat.e2e_tests_light_1.utils.StringParsers.parseIntegerFromString;

public class ProjectPageTests extends BaseTest {


    @BeforeEach
    void openProjectsPage() {
        app.projectsPage.open();
        app.projectsPage.isLoaded();
    }

    @Test
    public void userCanFindProjectWithTests() {
        app.projectsPage.searchForProject(targetProjectName);
        app.projectsPage.selectProject(targetProjectName);
        app.projectPage.isLoaded(targetProjectName);
    }

    @Test
    public void anotherTest() {
        app.projectsPage.searchForProject(targetProjectName);
        SelenideElement targetProject = app.projectsPage.countOfProjectsShouldBeEqualTo(1).first();
        app.projectsPage.countOfTestCasesShouldBeEqualTo(targetProject, 0);

        app.projectsPage.totalCountOfProjectsIsVisible();
        var totalProjects = app.projectsPage.getTotalCountOfTestCases();
        var actualCountOfTotalTests = parseIntegerFromString(totalProjects);
        Assertions.assertTrue(actualCountOfTotalTests > 100);

    }

    @Test
    public void exampleAssertDouble() {
        var text = "15.4 coverage";
        Double actualDouble = StringParsers.parseDoubleFromString(text);

        Assertions.assertEquals(15.4, actualDouble);
    }

    @Test
    public void exampleParseInteger() {
        var text = "0 tests";
        Integer actual = parseIntegerFromString(text);

        Assertions.assertEquals(0, actual);
    }

    @Test
    public void exampleParseBoolean() {
        var text = "true";
        Boolean actual = Boolean.parseBoolean(text);

        Assertions.assertEquals(false, actual);
    }


    // My Tests

    @Test
    public void userCanRenameProjectInFreeProjects() {
        app.projectsPage.selectFreeProjectsInProjectsDropdown().selectExistingProjectInFreeProjects();
        app.projectPage.openSettingsOfTheFreeProject()
                .navigateToProjectInfoSettings()
                .renameExistingProjectInFreeProjects("Renamed project")
                .saveChangesOfProjectInfoInFreeProjects()
                .verifyThatProjectNameIsChanged("Renamed project");
    }

    // My Tests

}

