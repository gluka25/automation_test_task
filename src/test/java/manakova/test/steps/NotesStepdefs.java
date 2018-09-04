package manakova.test.steps;

import com.codeborne.selenide.Condition;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import manakova.test.configuration.Config;
import manakova.test.pageobjects.Header;
import manakova.test.pageobjects.HomePage;
import manakova.test.pageobjects.Menu;
import manakova.test.pageobjects.NotesPage;

import java.util.Date;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class NotesStepdefs {

    private final HomePage homePage = page(HomePage.class);
    private final Menu menu = page(Menu.class);
    private final NotesPage notesPage = page(NotesPage.class);
    private final Header header = page(Header.class);
    private String noteTitle;

    @Before("@createNewobjects")
    public void loginBeforeCreateNote() {
        open(Config.getTestProperty("homeURL"));
        homePage.login(Config.getTestProperty("testUserEmail"), Config.getTestProperty("testUserPass"));
    }

    //---------------------------------GIVEN---------------------------------------

    @Given("^open Notes page$")
    public void openNotesPage() {
        menu.getNoteMenuButton().click();
    }

    //---------------------------------WHEN---------------------------------------

    @When("^I click button Add note$")
    public void iClickButtonAddNote() {
        notesPage.getNotesList().should(Condition.appear);
        notesPage.getAddNoteButton().click();
    }

    @And("^fill in Title field with value \"([^\"]*)\"$")
    public void fillInTitleFieldWithValue(String title) {
        noteTitle = title;
        notesPage.getTitleInputNotePopUp().setValue(title);
    }

    @And("^choose date \"([^\"]*)\"$")
    public void chooseDate(Date date) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^select advanced settings: show in \"([^\"]*)\" and URL \"([^\"]*)\"$")
    public void selectAdvancedSettingsShowInAndURL(String country, String url) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^fill in description by \"([^\"]*)\"$")
    public void fillInDescriptionBy(String description) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^save note$")
    public void saveNote() {
        notesPage.getSaveButtonNotePopUp().click();
    }

    //--------------------------------Then----------------------------------------------------------

    @Then("^note should be saved$")
    public void noteShouldBeSaved() {
        notesPage.getNewNoteTitleInTable().waitUntil(Condition.appear, 10_000);
        notesPage.getNewNoteTitleInTable().shouldHave(Condition.text(noteTitle));
    }

    @And("^delete new note$")
    public void deleteNewNote() {
        notesPage.getSettingsButtonInTable().click();
        notesPage.getSettingsWindowInTable().should(Condition.appear);
        notesPage.getDeleteNoteButton().click();
        notesPage.getDialogWindow().should(Condition.appear);
        notesPage.getAcceptDialogWindow().click();
        notesPage.getSettingsWindowInTable().shouldNotBe(Condition.visible);
        notesPage.getNewNoteTitleInTable().shouldNotHave(Condition.text(noteTitle));
    }
}
