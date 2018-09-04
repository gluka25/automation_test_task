package manakova.test.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard {
    @FindBy(css = ".s-no-projects__input.s-input__control")
    private SelenideElement enterDomainField;

    @FindBy(css = ".s-no-projects__btn")
    private SelenideElement createProjectButton;

    public SelenideElement getCreateProjectButton() {
        return createProjectButton;
    }

    public SelenideElement getEnterDomainField() {
        return enterDomainField;
    }
}
