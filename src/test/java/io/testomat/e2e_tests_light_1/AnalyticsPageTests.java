package io.testomat.e2e_tests_light_1;

import io.testomat.e2e_tests_light_1.web.pages.AnalyticsPage;
import org.junit.jupiter.api.Test;



public class AnalyticsPageTests extends BaseTest {



    // My Tests
    @Test
    public void userCanFilterProjectsWithSelectAllOption() {
        app.analyticsPage.navigateToAnalyticsPage()
                .openProjectsFilter()
                .clickOnSelectAllFilterOption()
                .applyProjectsFilter()
                .openProjectsFilter()
                .verifyThatFilterOptionIsSelected();
    }
    // My Tests
}
