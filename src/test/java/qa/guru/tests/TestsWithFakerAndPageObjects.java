package qa.guru.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import qa.guru.pages.RegistrationFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestsWithFakerAndPageObjects {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

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
        String userNumber = "89111559494";
        String month = "January";
        String year = "1985";
        String day = "17";
        String subjects = "Maths";
        String hobby = "Music";
        String picture = "img/privet.png";
        String address = faker.address().streetAddress();
        String state = "NCR";
        String city = "Delhi";

        registrationFormPage.openPage()
                //заносим данные в форму
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateBirth(day, month, year)
                .setSubjectInput(subjects)
                .setHobby(hobby)
                .setUploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

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
