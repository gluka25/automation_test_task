package manakova.test.pageobjects;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelenideExtention {
    public static void awaitLoad() {
        for (int i = 0; i < 10; i++) {
            new WebDriverWait(WebDriverRunner.getWebDriver(), 20).until(
                    ExpectedConditions.jsReturnsValue(
                            "return document.readyState === 'complete' ? true : false"));
        }
    }
}
