import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {

    SelenideElement firstName = $("#firstName");
    SelenideElement lastName = $("#lastName");
    SelenideElement userEmail = $("#userEmail");
    SelenideElement gender = $("#genterWrapper");
    SelenideElement userNumber = $("#userNumber");
    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    SelenideElement datepickerMonth = $(".react-datepicker__month-select");
    SelenideElement datepickerDey = $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)");
    SelenideElement datepickerYear = $(".react-datepicker__year-select");
    SelenideElement subjects = $("#subjectsInput");
    SelenideElement hobbies = $(".custom-control.custom-checkbox.custom-control-inline");
    SelenideElement pictures = $("#uploadPicture");
    SelenideElement currentAddress = $("#currentAddress");
    SelenideElement state = $("#state");
    SelenideElement city = $("#city");
    SelenideElement optionMenuNCR = $(byText("NCR"));
    SelenideElement cityGurgaon = $(byText("Gurgaon"));
    SelenideElement submit = $("#submit");

    @BeforeEach
    void BeforeEach() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }


    @Test
    void form() {
        //arrange
        open("https://demoqa.com/automation-practice-form");
        String name = "София";
        String lastNam = "Прекрасная";
        String email = "QA_duru@googl.com";
        String phone = "7919345779";
        String month = "April";
        String year = "2002";
        String subject = "Computer Science";
        String hobbiesText = "Sports";
        String address = "Москва, Скатертный переулок 16";
        String fileName = "cupcake.png";

        //act
        firstName.setValue(name);
        lastName.setValue(lastNam);
        userEmail.setValue(email);
        gender.click();
        userNumber.setValue(phone);
        dateOfBirthInput.click();
        datepickerMonth.click();
        datepickerMonth.selectOption(month);
        datepickerYear.click();
        datepickerYear.selectOption(year);
        datepickerDey.hover().click();
        subjects.click();
        subjects.setValue(subject).hover().pressEnter();
        hobbies.$(byText(hobbiesText)).click();
        pictures.uploadFromClasspath(fileName);
        currentAddress.setValue(address);
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        state.click();
        optionMenuNCR.click();
        city.click();
        cityGurgaon.click();
        submit.click();

        //assert
        $(".modal-body").shouldBe(visible);
        $(".modal-body").shouldBe(text(name)).shouldHave(text(name)).shouldHave(text(email))
                .shouldHave(text(phone)).shouldHave(text("Female")).shouldHave(text(month))
                .shouldHave(text(year)).shouldHave(text(hobbiesText)).shouldHave(text(fileName))
                .shouldHave(text(address)).shouldHave(text("NCR Gurgaon"));
    }
}
