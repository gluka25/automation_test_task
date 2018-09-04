package manakova.test.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class Menu {
    @FindBy(linkText = "Notes")
    private SelenideElement noteMenuButton;

    @FindBy(css = "[data-ga-label='dashboard']")
    private SelenideElement dashboardMenuButton;

    public SelenideElement getDashboardMenuButton() {
        return dashboardMenuButton;
    }

    public SelenideElement getNoteMenuButton() {
        return noteMenuButton;
    }
}
