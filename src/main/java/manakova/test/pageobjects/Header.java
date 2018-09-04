package manakova.test.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class Header {
    @FindBy(css = "[data-test='header-menu__user']")
    private SelenideElement profileButton;

    @FindBy(css = ".header-dropdown__description")
    private SelenideElement emailProfileMenu;

    @FindBy(linkText = "Log out")
    private SelenideElement logoutButton;

    public SelenideElement getProfileButton() {
        return profileButton.$(By.cssSelector(".header-dropdown__toggle"));
    }

    public SelenideElement getEmailProfileMenu() {
        return emailProfileMenu;
    }

    public SelenideElement getLogoutButton() {
        return logoutButton;
    }

    public void logout() {
        getProfileButton().click();
        getLogoutButton().click();
    }
}
