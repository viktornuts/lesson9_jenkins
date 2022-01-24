package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFromTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Liza");
        $("#lastName").setValue("Petrova");
        $("#userEmail").setValue("petro@mail.ru");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("89009000505");
        $("#dateOfBirthInput").click();
        $("[class*='month-select']").selectOptionByValue("5");
        $("[class*='year-select']").selectOptionByValue("1988");
        $("[class*='datepicker__day--010']").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("[for*='hobbies-checkbox-2']").click();
        //File file = new File("src/test/resources/b2b.jpg");
        //$("[class*='form-control-file']").uploadFile(file);
        $("#currentAddress").setValue("Tomsk, Lenina 56-2");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").scrollIntoView(true).click();;

        $("[class*=modal-content]").should(visible);
        $(byText("Thanks for submitting the form")).should(appear);
        $(".table-responsive").shouldHave(text("Liza")
                ,text("Petrova")
                ,text("petro@mail.ru")
                ,text("8900900050")
                ,text("10 June,1988")
                ,text("Tomsk, Lenina 56-2")
                ,text("Haryana Karnal"));
        $("#closeLargeModal").should(visible);
    }


}