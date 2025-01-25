package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.testomat.e2e_tests_light_1.utils.StringParsers.parseIntegerFromString;

public class CompaniesPageTests extends BaseTest {


    // my tests

    @Test
    public void verifyThatOnlyOneUserIsInFreeProjectsList() {
        app.companiesPage.navigateToCompaniesPage()
                .navigateToFreeProjectsFromCompaniesPage();
        SelenideElement actualAmountOfUsers = $(Selectors.byText("Users: 1")).shouldBe(Condition.visible);
        String actualAmount = actualAmountOfUsers.getText();
        Integer actual = parseIntegerFromString(actualAmount);
        Assertions.assertEquals(1, actual);
    }

    // my tests


}
