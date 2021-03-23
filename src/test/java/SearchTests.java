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
    public static void setup() {
        //use fullscreen
        Configuration.startMaximized = true;
    }

    @Test
    void selenideSearchTest() {

        //open target page

        open("https://demoqa.com/automation-practice-form");

        //initialize variables

        String firstName = "Jason";
        String lastName = "Born";
        String gender = "Male";
        String email = "pulsar@hotmail.com";
        String phoneNumber = "9253339898";
        String month = "4";
        String year = "1977";
        String day = "10";
        String subject1 = "Computer Science";
        String subject2 = "Math";
        String hobbie1 = "Sports";
        String hobbie2 = "Music";
        String filename = "hello_world.txt";
        String address = "LA, Oak str., 13";
        String state = "NCR";
        String city = "Noida";
        String pageHeader = "Thanks for submitting the form";
        //FILL OUT THE FORM

        //type name, surname, email, gender, phone number

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText(gender)).click();
        $("#userNumber").setValue(phoneNumber);

        //type date of birth

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue(month);    //month
        $(".react-datepicker__year-select").selectOptionByValue(year);      //year
        $(".react-datepicker__month").$(byText(day)).click();               //day

        //type subject

        $("#subjectsContainer").click();
        $("#subjectsInput").setValue(subject1).pressEnter();
        $("#subjectsInput").setValue(subject2).pressEnter();

        //type hobbie

        $(byText(hobbie1)).click();
        $(byText(hobbie2)).click();

        //load file hello_world.txt

        //$("#uploadPicture").uploadFile(new File("src/test/resources/hello_world.txt")); //long way
        $("#uploadPicture").uploadFromClasspath(filename);                      //optimal way

        //type address

        $("#currentAddress").setValue(address).pressTab();

        //type state

        $("#state").click();
        $(byText(state)).click();

        //type city

        $("#city").click();
        $(byText(city)).click();

        //submit the form

        $("#submit").pressEnter();

        //CHECK THE FORM

        //check the header, should be "Thanks for submitting the form"

        $("#example-modal-sizes-title-lg").shouldHave(text(pageHeader));

        //check the form elements

        $(".table-responsive").shouldHave(
                text(firstName),
                text(lastName),
                text(email),
                text(gender),
                text(phoneNumber),
                text(day),
                text("may"),
                text(year),
                text(subject1),
                text(subject2),
                text(hobbie1),
                text(hobbie2),
                text(filename),
                text(address),
                text(state),
                text(city));
    }
}