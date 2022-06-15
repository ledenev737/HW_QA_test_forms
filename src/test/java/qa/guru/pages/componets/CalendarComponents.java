package qa.guru.pages.componets;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponents {
    public void setDate(String Day, String Month, String Year) {
        $(".react-datepicker__month-select").selectOption(Day);
        $(".react-datepicker__year-select").selectOption(Month);
        $(".react-datepicker__day--0" + Day +
                        ":not(.react-datepicker__day--outside-month)").$(byText(Year)).click();
    }
}
