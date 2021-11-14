package allure;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {

    private final static String repository = "eroshenkoam/allure-example";
    private final static String text = "Listeners NamedBy";

     WebSteps steps = new WebSteps();

    @Test
    @Owner("Belousova")
    @DisplayName("Шаги с аннотацией @Step")
    public void testSearch() {
        steps.openMainPage();
        steps.searchForRepository(repository);
        steps.goToRepository(repository);
        steps.clickOnIssueTab();
        steps.shouldSeeIssueWithText(text);
    }
}
