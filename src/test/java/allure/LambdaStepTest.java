package allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {

    private final static String repository = "eroshenkoam/allure-example";
    private final static String issues_text ="Listeners NamedBy";

    @Test
    public void testGithub() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий" + repository, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(repository);
            $(".header-search-input").pressEnter();
        });

        step("Переходим в репозиторий" + repository, () -> {
            $(linkText(repository)).click();
        });

        step("Открываем раздел Issues", () -> {
            $(partialLinkText("Issues")).click();
        });

        step("Проверяем наличие Issues с номером" + repository, () -> {
            $(byText(issues_text)).should(Condition.visible);
        });

    }
}
