package io.testomat.e2e_tests_light_1;

import io.testomat.e2e_tests_light_1.web.pages.AccountPage;
import org.junit.jupiter.api.Test;

public class AccountPageTests extends BaseTest {

    private static final AccountPage accountPage = new AccountPage();


    // My Tests
    @Test
    public void userCanChangeThemeToDark() {
        accountPage.navigateToAccountPage()
                .openThemeDropdown()
                .verifyThatLightThemeIsSelected()
                .changeThemeToDark()
                .saveChangesOfUserAccountUpdate()
                .verifyThatDarkThemeIsSelected();
    }
    // My Tests
}
