package io.testomat.e2e_tests_light_1.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.testomat.e2e_tests_light_1.utils.StringParsers.parseIntegerFromString;

public class CompaniesPage {

    public CompaniesPage navigateToCompaniesPage() {
            $(Selectors.byLinkText("Companies")).click();
            return this;
        }

    public CompaniesPage navigateToFreeProjectsFromCompaniesPage() {
        $("[href=\"/free_company\"]").click();
        return this;
    }


    }

