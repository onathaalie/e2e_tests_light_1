package io.testomat.e2e_tests_light_1.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class ReadmePage {

    public ReadmePage clickOnEditReadme() {
        $(Selectors.byText("Edit Readme")).click();
        Selenide.switchTo().frame($("#modal-overlays iframe[src='/ember-monaco/frame.html']"));
        return this;
    }

    public ReadmePage editFirstLineInEditor(String targetText) {
        $(".view-lines div span").click();
        $("textarea").setValue(targetText);
        return this;
    }

    public ReadmePage clickOnUpdate() {
        Selenide.switchTo().defaultContent();
        $(Selectors.byText("Update")).click();
        return this;
    }

    public ReadmePage clickOnCancel() {
        Selenide.switchTo().defaultContent();
        $(Selectors.byText("Cancel")).click();
        return this;
    }

    public ReadmePage isLoaded() {
        $("h2 ").shouldHave(Condition.text("Readme"));
        return this;
    }


    public ReadmePage readmeIsUpdated(String targetText) {
        $(".detail-view-content").shouldHave(Condition.text(targetText));
        return this;
    }
}
