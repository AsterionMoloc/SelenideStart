package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideSearch {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = false;
    }
        @Test
         void SelenideSearch() {

            //открыть страницу Selenide на гитхаб
            open("https://github.com/selenide/selenide");

            //кликнуть по ссылке на вики
            $x("//span[@data-content='Wiki']").click();

            //проверить,пристуствует ли в списке страниц текст SoftAssertions
            $("body").shouldHave(Condition.text("SoftAssertions"));

            //кликнуть по ссылке SoftAssertions
            $x("//*[text()='SoftAssertions']").click();

            //Убедится, что на странице присуствует пример кода JUnit5
            $x("//ol[@start='3']").scrollTo();
            $x("//ol[@start='3']").shouldHave(Condition.text("Using JUnit5 extend test class"));

        }



}
