package io.testomat.e2e_tests_light_1;

import io.testomat.e2e_tests_light_1.web.pages.AnalyticsPage;
import org.junit.jupiter.api.Test;



public class AnalyticsPageTests extends BaseTest {

    private static final AnalyticsPage analyticsPage = new AnalyticsPage();

    // My Tests
    @Test
    public void userCanFilterProjectsWithSelectAllOption() {
        analyticsPage.navigateToAnalyticsPage();
        analyticsPage.openProjectsFilter();
        analyticsPage.clickOnSelectAllFilterOption();
        analyticsPage.applyProjectsFilter();
        analyticsPage.openProjectsFilter();
        analyticsPage.verifyThatFilterOptionIsSelected();
    }
    // My Tests
}
