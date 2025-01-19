package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.*;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CollectionOfElementsTests extends BaseTest {

    @Test
    @DisplayName("Find all product experiments")
    void findAllProductExperiments() {
        var labelCountOfTests = $$("ul li p")
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement labelCountOfTest : labelCountOfTests) {
            labelCountOfTest.shouldHave(Condition.text("14 tests").or(Condition.text("0 tests")));
        }

        // another way to check
        $$(Selectors.byText("14 tests")).shouldHave(CollectionCondition.size(1));
        $$(Selectors.byText("0 tests")).shouldHave(CollectionCondition.size(68));

        // another way to check
        labelCountOfTests.filter(Condition.text("14 tests")).shouldHave(CollectionCondition.size(1));
        labelCountOfTests.filter(Condition.text("0 tests")).shouldHave(CollectionCondition.size(68));

    }

    @Test
    @DisplayName("clipboard")
    void clipboard() {
        Selenide.clipboard().setText("olo");
        Selenide.clipboard().shouldHave(ClipboardConditions.content("olo"));

        Selenide.localStorage().shouldHave(LocalStorageConditions.itemWithValue("name", "target name"));
    }



    public static void main(String[] args) {
        List<String> olo1 = Arrays.asList("Olo1", "Olo2", "Olo3"); // список
        System.out.println("olo1 " + olo1);
        olo1.forEach(System.out::println);

        int[] integers = {1, 2, 3, 4, 5};
        System.out.println("integers " + integers.toString());
        System.out.println("integers " + Arrays.toString(integers));

        for (int i = 0; i < olo1.size(); i++) {
            System.out.println("inetegers[i] = " + integers[i]);
        }

        for (int i: integers) {
            System.out.println("integers[i] = " + i);
        }



        String[] olo = {"Olo1", "Olo2", "Olo3"}; // масив
        System.out.println("olo " + olo);

        for (String oloitem : olo) {
            System.out.println("oloitem = " + oloitem);
        }
        
        System.out.println("olo to string" + Arrays.toString(olo));


    }

}
