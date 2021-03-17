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
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test
    void selenideSearchTest() {
        open("https://demoqa.com/automation-practice-form");
        Selenide.sleep(500);
        $(byId("firstName")).setValue("Jason");
        $(byId("lastName")).setValue("Born");
        $(byId("userEmail")).setValue("jborn@gmail.com");
        $(byText("Male")).click();
        $(byId("userNumber")).setValue("1118889991");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $(".react-datepicker__year-select").selectOptionByValue("1977");
        $(".react-datepicker__day.react-datepicker__day--012").click();
        //???
        $(byId("subjectsInput")).setValue("QA Guru homework");
        //$(byId("subjectsContainer")).setValue("QA Guru homework");

        $(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/hello_world.txt"));
        $(byId("currentAddress")).setValue("Mars").pressTab();
        $(byId("state")).click();
        $(byText("NCR")).click();
        $(byId("city")).click();
        $(byText("Noida")).click();
        $(byId("submit")).pressEnter();
        Selenide.sleep(2000);

        // $("#search").shouldHave(text("beslite@gmail.com"));
    }
}