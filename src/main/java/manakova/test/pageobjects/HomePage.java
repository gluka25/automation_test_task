package manakova.test.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;


public class HomePage {
    @FindBy(css = "#srf-login-btn")
    private SelenideElement loginButton;

    @FindBy(css = ".sso-base-popup__container")
    private SelenideElement loginPopup;

    public SelenideElement getLoginButton() {
        return loginButton;
    }

    public SelenideElement getLoginPopup() {
        return loginPopup;
    }

    public SelenideElement getEmailInputLoginPopup() {
        return loginPopup.$(By.name("email"));
    }

    public SelenideElement getPassInputLoginPopup() {
        return loginPopup.$(By.name("password"));
    }

    public SelenideElement getLoginButtonLoginPopup() {
        return loginPopup.$("[data-test='auth-popup__submit']");
    }

    public void login(String email, String pass) {
        getLoginButton().click();
        getLoginPopup().should(Condition.appear);
        getEmailInputLoginPopup().setValue(email);
        getPassInputLoginPopup().setValue(pass);
        getLoginButtonLoginPopup().click();
    }
}
