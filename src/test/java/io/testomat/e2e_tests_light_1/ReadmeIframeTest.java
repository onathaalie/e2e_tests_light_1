package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit5.TextReportExtension;
import io.testomat.e2e_tests_light_1.web.pages.ReadmePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


public class ReadmeIframeTest extends BaseTest {

    @Test
    @DisplayName("Update Read me text in Iframe")
    void updateReadMeTextInIframe() {
        app.projectsPage.isLoaded()
                .searchForProject(targetProjectName)
                .selectProject(targetProjectName);

        app.projectPage.openReadme().editReadme();

        app.readmePage.isLoaded()
                .clickOnEditReadme()
                .editFirstLineInEditor("OLOLO")
                .clickOnUpdate();

        app.projectPage.openReadme();
        new ReadmePage().readmeIsUpdated("OLOLO");

    }





    @Test
    @DisplayName("Update Read me text in Iframe")
    void RreadmeTest() {};

}
