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
        $(byId("firstName")).setValue("Maksim");
        $(byId("lastName")).setValue("Bessudnov");
        $(byId("userEmail")).setValue("beslite@gmail.com");
        //???
        $(byClassName("custom-control-label")).click();
        //???
        $(byId("userNumber")).setValue("9263069330");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__year-select").selectOptionByValue("1977");
        $(".react-datepicker__day.react-datepicker__day--010").click();

        File file = $("#cv").uploadFile(new File("src/test/java/../resources/hello_world.txt"));
        $("#submit").click();
        $(byClassName("form-control")).setValue("Moscow").pressEnter();
        //$("#search").shouldHave(text("selenide.org"));
        Selenide.sleep(1000);
    }
}