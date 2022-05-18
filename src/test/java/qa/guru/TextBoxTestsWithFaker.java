package qa.guru;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTestsWithFaker {

    Faker faker = new Faker();

    @BeforeAll
    static void SetUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest(){

        //вводные данные в форму
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = "Male";
        String userNumber = "89991112221";
        String month = "January";
        String year = "1985";
        String day = "17";
        String subjects = "Maths";
        String hobby = "Music";
        String picture = "img/privet.png";
        String address = faker.address().streetAddress();
        String state = "NCR";
        String city = "Delhi";

        //открытие страницы
        open("/automation-practice-form");

        //убираем баннер и футер
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        //заносим данные в форму
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month").$(byText(day)).click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();

        // проверка
        $(".table-responsive").shouldHave(
                text(firstName + " " + lastName),
                text(email),
                text(gender),
                text(userNumber),
                text(day + " " + month + "," + year),
                text(subjects),
                text(hobby),
                text(picture.substring(7)),
                text(address),
                text(state + " " + city)
        );
    }
}
