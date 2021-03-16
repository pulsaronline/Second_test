import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {

    @Test
    void selenideSearchTest() {
        open("https://demoqa.com/automation-practice-form");
        Selenide.sleep(500);
        $(byId("firstName")).setValue("Jason");
        $(byId("lastName")).setValue("Born");
        $(byId("userEmail")).setValue("beslite@gmail.com");
        $(byText("Male")).click();
        $(byId("userNumber")).setValue("9263069330");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__year-select").selectOptionByValue("1977");
        $(".react-datepicker__day.react-datepicker__day--010").click();
        //???
        $(byId("subjectsInput")).setValue("QA Guru homework").click();
        $(byText("Sports")).click();
        File file = $("#uploadPicture").uploadFile(new File("src/test/resources/hello_world.txt"));
        //$("#uploadPicture").click();
        $(byId("currentAddress")).setValue("Another world").pressTab();

       // $("#search").shouldHave(text("beslite@gmail.com"));
        Selenide.sleep(3000);
        $("#Submit").click();
        Selenide.sleep(3000);
    }
}