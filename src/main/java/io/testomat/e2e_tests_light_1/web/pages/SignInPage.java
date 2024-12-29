package io.testomat.e2e_tests_light_1.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class SignInPage {

    public void open() {
        Selenide.open("/users/sign_in");
    }

    public void loginUser(String email, String password) {
        $("#content-desktop #user_email").setValue("nathalieoliinyk@gmail.com");
        $("#content-desktop #user_password").setValue("natali1234567890");
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        $("#content-desktop #user_email").shouldBe(Condition.hidden);
        $("#content-desktop #user_password").shouldBe(Condition.hidden);
    }


}
