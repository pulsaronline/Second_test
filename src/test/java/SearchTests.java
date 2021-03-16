import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {

    @Test
    void selenideSearchTest() {
        open("https://demoqa.com/automation-practice-form");
        Selenide.sleep(500);
        $(byId("firstName")).setValue("Maksim").pressEnter();
        $(byId("lastName")).setValue("Bessudnov").pressEnter();
        $(byId("userEmail")).setValue("beslite@gmail.com").pressEnter();
        //???
        $(byClassName("custom-control-label")).click();
        //???
        $(byId("userNumber")).setValue("9263069330").pressEnter();
        $(By.cssSelector("[type='year-month-date']")).setValue("2018-06-01");
        $(byId("subjectsInput")).setValue("QA engineering study").pressEnter();
        //$(byId("dateOfBirthInput")).setValue("02/20/2002").pressEnter();


        $("#search").shouldHave(text("selenide.org"));
        Selenide.sleep(1000);
    }
}