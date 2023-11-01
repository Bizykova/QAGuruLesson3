import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {

    SelenideElement firstName = $("#firstName");
    SelenideElement lastName = $("#lastName");
    SelenideElement userEmail = $("#userEmail");
    SelenideElement gender = $("[for=gender-radio-2]");
    SelenideElement userNumber = $("#userNumber");
    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    SelenideElement datepickerMonth = $(".react-datepicker__month-select");
   SelenideElement datepickerDey = $$(".react-datepicker__week").get(0).$(".react-datepicker__day.react-datepicker__day--001");
    SelenideElement datepickerYear = $(".react-datepicker__year-select");
    SelenideElement subjects = $("#subjectsInput");
    SelenideElement hobbies = $(".custom-control.custom-checkbox.custom-control-inline");
    SelenideElement pictures = $("#uploadPicture");
    SelenideElement currentAddress = $("#currentAddress");
    SelenideElement state = $("#state");
    SelenideElement city = $("#city");
    SelenideElement optionMenuNCR = $(byText("NCR"));
    SelenideElement cityGurgaon = $(byText("Gurgaon"));

    @BeforeEach
    void BeforeEach(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }


    @Test
    void Form() {
        open("https://demoqa.com/automation-practice-form");
        firstName.setValue("София");
        lastName.setValue("Прекрасная");
        userEmail.setValue("QA_duru@googl.com");
        gender.click();
        userNumber.setValue("7919345779");
        dateOfBirthInput.click();
        datepickerMonth.click();
        datepickerMonth.selectOption("April");
        datepickerYear.click();
        datepickerYear.selectOption("2002");
        datepickerDey.hover().click();
        sleep (3000);
        subjects.click();
        subjects.setValue("Computer Science").pressEnter();
        hobbies.$(byText("Sports")).click();
        File file = pictures.uploadFile(new File("src/test/java/image/cupcake.png"));
        currentAddress.setValue("Москва, Скатертный переулок 16");
        state.scrollTo();
        state.click();
        optionMenuNCR.click();
        city.click();
        city.scrollTo();
        cityGurgaon.click();
    }
}
