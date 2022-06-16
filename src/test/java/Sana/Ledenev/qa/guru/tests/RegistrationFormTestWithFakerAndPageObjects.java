package Sana.Ledenev.qa.guru.tests;

import Sana.Ledenev.qa.guru.pages.RegistrationFormPage;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class RegistrationFormTestWithFakerAndPageObjects {

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
                .clickSubmit()

                // проверка

                .checkResult("Student Name", firstName + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", day + month + "," + year)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City", state + city);
    }
}
