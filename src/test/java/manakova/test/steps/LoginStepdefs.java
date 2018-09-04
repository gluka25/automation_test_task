package manakova.test.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import manakova.test.configuration.Config;
import manakova.test.pageobjects.Header;
import manakova.test.pageobjects.HomePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginStepdefs {

    //private final String homeURL = "https://www.semrush.com/";

    private final HomePage homePage = page(HomePage.class);

    private final Header header = page(Header.class);

    private String loginEmail;


    @After
    public void logoutAfterLoginTest() {
        header.logout();
    }

    //----------------------------------Given---------------------------------------------
    @Given("^open semrush home page$")
    public void openSemrushCom() {
        open(Config.getTestProperty("homeURL"));
    }

    //----------------------------------When----------------------------------------------
    @When("^I press button Log in$")
    public void pressLoginButtonOnMainPage() {
        homePage.getLoginButton().click();
        homePage.getLoginPopup().should(appear);
    }

    @And("^type to email input \"([^\"]*)\"$")
    public void typeToEmailInput(String email) {
        loginEmail = email;
        homePage.getEmailInputLoginPopup().setValue(email);
    }

    @And("^type to pass input \"([^\"]*)\"$")
    public void typeToPassInput(String pass) {
        homePage.getPassInputLoginPopup().setValue(pass);
    }

    @And("^press button Login in login popup$")
    public void pressButtonInLoginPopup() {
        homePage.getLoginButtonLoginPopup().click();
        homePage.getLoginPopup().waitUntil(disappear, 10000);
    }

    //----------------------------------Then----------------------------------------------
    @Then("^authorization is completed$")
    public void authorizationIsCompleted() {
        header.getProfileButton().should(exist);
        header.getProfileButton().shouldBe(visible);
        header.getProfileButton().click();
        if (!header.getEmailProfileMenu().isDisplayed())
            header.getProfileButton().click();
        header.getEmailProfileMenu().shouldBe(visible);
        header.getEmailProfileMenu().shouldHave(text(loginEmail));
        header.getLogoutButton().should(exist);
        header.getProfileButton().click();
    }
}



