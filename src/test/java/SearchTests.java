import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {

    @BeforeAll
    public static void init() {
        //use Chrome browser, fullscreen
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test
    void selenideSearchTest() {
        //initialize variables

        String firstName = "Jason";
        String lastName = "Born";
        String gender = "Male";
        String email = "pulsar@hotmail.com";
        String phoneNumber = "9253339898";
        String month = "4";
        String year = "1977";

        //open target page

        open("https://demoqa.com/automation-practice-form");

        //wait ~0,5 sec

        Selenide.sleep(500);

        //FILL OUT THE FORM

        //type name, surname, email, gender, phone number

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText(gender)).click();
        $("#userNumber").setValue(phoneNumber);

        //type date of birth

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue(month);
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__day.react-datepicker__day--012").click();

        //type subject

        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#subjectsInput").setValue("Math").pressEnter();

        //type hobbie

        $(byText("Sports")).click();
        $(byText("Music")).click();

        //load file hello_world.txt

        $("#uploadPicture").uploadFile(new File("src/test/resources/hello_world.txt"));

        //type address

        $(byId("currentAddress")).setValue("LA, Oak str., 13").pressTab();

        //type state

        $(byId("state")).click();
        $(byText("NCR")).click();

        //type city
        $(byId("city")).click();
        $(byText("Noida")).click();

        //submit the form
        $(byId("submit")).pressEnter();
        Selenide.sleep(3000);

        //CHECK FORM ELEMENTS

        //check the header, should be "Practice Form"

        $(".main-header").shouldHave(text("Practice Form"));

        //check the form elements

        $(".table-responsive").shouldHave(text(firstName), text(lastName),
                text(email),
                text(gender),
                text(phoneNumber),
                text("12 May,1977"),
                text("Computer Science, Maths"),
                text("Sports, Music"),
                text("hello_world.txt"),
                text("LA, Oak str., 13"),
                text("NCR Noida"));
    }
}