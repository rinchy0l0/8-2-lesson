package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm {

    @BeforeAll
    static void configuration() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void successfulRegistrationTest() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("Karina");
        $("#lastName").setValue("Bardina");
        $("#userEmail").setValue("bar1@mail.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8929045522");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1997");
        $("[aria-label='Choose Thursday, October 16th, 1997']").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("./img/1.png");
        $("#currentAddress").setValue("NN VV dom 7");

        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("Karina Bardina"), text("bar1@mail.ru"),
                text("Female"),
                text("8929045522"), text("16 October,1997"), text("Arts"),
                text("Music"), text("1.png"), text("NN VV dom 7"), text("NCR Delhi"));
    }
}
