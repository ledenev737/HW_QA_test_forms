package qa.guru.pages;

import qa.guru.pages.componets.CalendarComponents;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    CalendarComponents calendar = new CalendarComponents();
    // locators


    // actions
    public RegistrationFormPage openPage() {
        //открытие страницы
        open("/automation-practice-form");

        //убираем баннер и футер
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        $("#firstName").setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        $("#lastName").setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationFormPage setDateBirth(String Day, String Month, String Year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(Day, Month, Year);

        return this;
    }

    public RegistrationFormPage setSubjectInput(String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobby(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setUploadPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;
    }

    public RegistrationFormPage setState(String value) {
        $("#state").click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setCity(String value) {
        $("#city").click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationFormPage clickSubmit() {
        $("#submit").click();

        return this;
    }
}
