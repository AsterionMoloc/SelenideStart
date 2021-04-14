package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideSearch {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }
        @Test
         void SelenideSearch() {

            //открыть гитхаб
            open("http://github.com/");

            //в поле поиска ввести Selenide
            $x("//div//input[@name='q']").click();
            $x("//div//input[@name='q']").val("Selenide");
            $x("//div//input[@name='q']").pressEnter();

            //кликнуть по ссылке на вики
            $(Selectors.byText("Wikis")).click();

            //проверить,пристуствует ли на странице текст SoftAssertions
            $("body").shouldHave(Condition.text("SoftAssertions"));

            //кликнуть по ссылке SoftAssertions
            $x("//div/a[text()='SoftAssertions']").click();

            //Убедится, что на странице присуствует присер кода JUnit5
            $("body").shouldHave(Condition.text("Using JUnit5 extend test class"));

        }



}
