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
        String phoneNumber = "89253339898";

        //open target page

        open("https://demoqa.com/automation-practice-form");

        //check the header, should be wrote Practice Form

        $(".main-header").shouldHave(text("Practice Form"));

        //wait ~0,5 sec

        Selenide.sleep(500);

        //FILL OUT THE FORM

        //type name, surname, email, gender, phone number

       /* $(byId(firstName)).setValue("Jason");
        $(byId("lastName")).setValue("Born");
        $(byId("userEmail")).setValue("jborn@gmail.com");
        $(byText("Male")).click();
        $(byId("userNumber")).setValue("1118889991");*/

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText(gender)).click();
        $("#userNumber").setValue(phoneNumber);

        //type date of birth

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $(".react-datepicker__year-select").selectOptionByValue("1977");
        $(".react-datepicker__day.react-datepicker__day--012").click();

        //type subject
        //$(byId("subjectsInput")).setValue("Subjects");
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("English").pressEnter();

        //type hobbie

        $(byText("Sports")).click();

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
        Selenide.sleep(4000);

        //CHECK FORM ELEMENTS


    }
}