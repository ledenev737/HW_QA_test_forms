package qa.guru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void SetUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest(){
        String firstName = "Aleksandr";
        String lastName = "Ledenev";
        String email = "Ledenev737@gmail.com";
        String userNumber = "89991112221";
        String dateOfBirth = "17 Jan 1985";
        String subjects = "Maths";
        String picture = "C:/privet.png";
        String adress = "Bali";
        String state = "NCR";
        String city = "Delhi";

        open("/automation-practice-form");

        $("[id=firstName").setValue(firstName);
        $("[id=lastName").setValue(lastName);
        $("[id=userEmail").setValue(email);
        $("[id=gender-radio-1").click();
        $("[id=userNumber").setValue(userNumber);
        $("[id=dateOfBirthInput").setValue(dateOfBirth);
        $("[id=subjectsContainer").setValue(subjects).pressEnter();
        $("[id=hobbies-checkbox-2").click();
        $("[id=uploadPicture").uploadFromClasspath(picture);
        $("[id=currentAddress").setValue(adress);
        $("[id=state").setValue(state);
        $("[id=state").setValue(city);
        $("[id=submit").click();

    }
}
