package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.testomat.e2e_tests_light_1.utils.StringParsers;
import io.testomat.e2e_tests_light_1.web.pages.ProjectPage;
import io.testomat.e2e_tests_light_1.web.pages.ProjectsPage;
import io.testomat.e2e_tests_light_1.web.pages.SignInPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.testomat.e2e_tests_light_1.utils.StringParsers.parseIntegerFromString;

public class ProjectPageTests extends BaseTest {

    private static final ProjectsPage projectsPage = new ProjectsPage();
    private static final SignInPage signInPage = new SignInPage();
    static String username = env.get("USERNAME");
    static String password = env.get("PASSWORD");
    private final ProjectPage projectPage = new ProjectPage();
    String targetProjectName = "Manufacture light";

    @BeforeAll
    static void openTestomatAndLogin() {
        signInPage.open();
        signInPage.loginUser(username, password);
        projectsPage.signInSuccess();
    }

    @BeforeEach
    void openProjectsPage() {
        projectsPage.open();
        projectsPage.isLoaded();
    }

    @Test
    public void userCanFindProjectWithTests() {
        projectsPage.searchForProject(targetProjectName);
        projectsPage.selectProject(targetProjectName);
        projectPage.isLoaded(targetProjectName);
    }

    @Test
    public void anotherTest() {
        projectsPage.searchForProject(targetProjectName);
        SelenideElement targetProject = projectsPage.countOfProjectsShouldBeEqualTo(1).first();
        projectsPage.countOfTestCasesShouldBeEqualTo(targetProject, 0);

        projectsPage.totalCountOfProjectsIsVisible();
        var totalProjects = projectsPage.getTotalCountOfTestCases();
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

    @Test
    public void userCanCreateCompany() {
        createCompany();
    }


    public void createCompany() {
        $("#content-desktop h2").shouldHave(Condition.text("Projects"));
        $("#content-desktop a:nth-of-type(2)").click();
        $("#content-desktop ul li").shouldHave(Condition.text("Companies"));
        $("#content-desktop button.common-btn-primary.common-btn-lg").click();
        $("#content-desktop h2").shouldHave(Condition.text("Create Company"));
        $("#company_title").shouldNotBe(Condition.empty);
        $("[name = commit]").click();
        $(".common-flash-success-right p").shouldHave(Condition.partialText("Company is created"));
    }


}

