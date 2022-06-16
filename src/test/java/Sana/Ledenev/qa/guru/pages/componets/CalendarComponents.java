package Sana.Ledenev.qa.guru.pages.componets;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponents {
    public void setDate(String Day, String Month, String Year) {
        $(".react-datepicker__month-select").selectOption(Month);
        $(".react-datepicker__year-select").selectOption(Year);
        $(".react-datepicker__month").$(byText(Day)).click();
    }
}
