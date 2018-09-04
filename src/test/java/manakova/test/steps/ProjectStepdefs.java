package manakova.test.steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import manakova.test.pageobjects.*;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.page;

public class ProjectStepdefs {

    private final Dashboard dashboard = page(Dashboard.class);

    private final ProjectPage projectPage = page(ProjectPage.class);

    private final HomePage homePage = page(HomePage.class);

    private final Header header = page(Header.class);

    private final Menu menu = page(Menu.class);

    private String newDomain;

    @Given("^I enter domain \"([^\"]*)\" in domain field$")
    public void iEnterDomainInDomainField(String domain) {
        newDomain = domain;
        dashboard.getCreateProjectButton().waitUntil(Condition.visible, 10_000);
        dashboard.getEnterDomainField().should(Condition.appear);
        dashboard.getEnterDomainField().setValue(domain);
    }

    @When("^I click create button on dashboard page$")
    public void iClickCreateButtonOnDashboardPage() {
        dashboard.getCreateProjectButton().click();
    }

    @Then("^project should be created$")
    public void projectShouldBeCreated() {
        Assert.assertEquals(projectPage.getProjectTitle().waitUntil(Condition.visible, 10_000).getText(),
                "Dashboard: " + newDomain);
    }

    @Then("^project should be deleted$")
    public void projectShouldBeDeleted() {
        SelenideExtention.awaitLoad();
        projectPage.getProjectSettingButton().waitUntil(Condition.appear, 10_000);
        SelenideExtention.awaitLoad();
        projectPage.getProjectSettingButton().click();
        while (!projectPage.getDeleteProjectButton().isDisplayed()) {
            SelenideExtention.awaitLoad();
            projectPage.getProjectSettingButton().click();
        }
        projectPage.getDeleteProjectButton().click();
        while (!projectPage.getProjectNameConfirmInput().isDisplayed()) {
            SelenideExtention.awaitLoad();
            projectPage.getDeleteProjectButton().click();
        }
        projectPage.getProjectNameConfirmInput().setValue(newDomain);
        projectPage.getDeleteButtonPopUp().click();
        header.logout();
    }
}
