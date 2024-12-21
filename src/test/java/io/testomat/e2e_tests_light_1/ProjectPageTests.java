package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectPageTests extends BaseTest{


    String baseUrl = env.get("BASE_URL");
    String username = env.get("USERNAME");
    String password = env.get("PASSWORD");
    String targetProjectName = "Manufacture light";

    @Test
    public void firstTest() {
        open(baseUrl);

        loginUser(username, password);

        searchForProject(targetProjectName);

        selectProject(targetProjectName);

        waitForProjectPageIsLoaded(targetProjectName);

    }

    private void waitForProjectPageIsLoaded(String targetProjectName) {
        $(".first h2").shouldHave(Condition.text(targetProjectName));
        $(".first [href*='/readme']").shouldHave(Condition.text("Readme"));
    }

    private void selectProject(String targetProjectName) {
        $(byText(targetProjectName)).click();
    }

    private void searchForProject(String targetProjectName) {
        $("#search").setValue(targetProjectName);
    }

    @Test
    public void anotherTest() {
        loginUser(username, password);

        searchForProject(targetProjectName);







    }

    public void loginUser(String email, String password){
        $("#content-desktop #user_email").setValue("nathalieoliinyk@gmail.com");
        $("#content-desktop #user_password").setValue("natali1234567890");
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        $(".common-flash-success").shouldBe(Condition.visible);
    }

}

