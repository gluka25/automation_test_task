package manakova.test.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage {
    @FindBy(css = ".pr-page__title-name")
    private SelenideElement projectTitle;

    @FindBy(css = ".s-project__settings-actions")
    private SelenideElement projectSettingButton;

    @FindBy(css = ".sr-infomenu-content")
    private SelenideElement projectSettingPopUp;

    @FindBy(linkText = "Delete")
    private SelenideElement deleteProjectButton;

    @FindBy(css = ".pr-dialog-attention")
    private SelenideElement domainNameInPopup;

    @FindBy(css = ".s-input__control.js-remove-input")
    private SelenideElement projectNameConfirmInput;

    @FindBy(css = ".s-btn.-s.-danger.js-remove")
    private SelenideElement deleteButtonPopUp;

    public SelenideElement getProjectSettingPopUp() {
        return projectSettingPopUp;
    }

    public SelenideElement getDeleteProjectButton() {
        return deleteProjectButton;
    }

    public SelenideElement getDomainNameInPopup() {
        return domainNameInPopup;
    }

    public SelenideElement getProjectNameConfirmInput() {
        return projectNameConfirmInput;
    }

    public SelenideElement getDeleteButtonPopUp() {
        return deleteButtonPopUp;
    }

    public SelenideElement getProjectSettingButton() {
        return projectSettingButton;
    }

    public SelenideElement getProjectTitle() {
        return projectTitle;
    }
}
