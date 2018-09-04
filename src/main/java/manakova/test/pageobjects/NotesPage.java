package manakova.test.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class NotesPage {
    @FindBy(css = "[data-cream-action='add-note']")
    private SelenideElement addNoteButton;

    @FindBy(css = ".cream-popup.notes-editor")
    private SelenideElement addNotePopUp;

    @FindBy(css = "[data-cream-ui='input-title']")
    private SelenideElement titleInputNotePopUp;

    @FindBy(css = "[data-cream-action='save']")
    private SelenideElement saveButtonNotePopUp;

    @FindBy(xpath = "//table[1]//span[@class='notes-note-title']")
    private SelenideElement newNoteTitleInTable;

    @FindBy(xpath = "//table//tr[1]//td[7]//div[1]//div[1]")
    private SelenideElement settingsButtonInTable;

    @FindBy(css = ".cream-dropdown__dropdown")
    private SelenideElement settingsWindowInTable;

    @FindBy(css = ".notes-dialog.cream-popup")
    private SelenideElement dialogWindow;

    @FindBy(css = ".notes-list-items-container")
    private SelenideElement notesList;

    public SelenideElement getAddNoteButton() {
        return addNoteButton;
    }

    public SelenideElement getAddNotePopUp() {
        return addNotePopUp;
    }

    public SelenideElement getTitleInputNotePopUp() {
        return titleInputNotePopUp;
    }

    public SelenideElement getSaveButtonNotePopUp() {
        return saveButtonNotePopUp;
    }

    public SelenideElement getNewNoteTitleInTable() {
        return newNoteTitleInTable;
    }

    public SelenideElement getSettingsWindowInTable() {
        return settingsWindowInTable;
    }

    public SelenideElement getDeleteNoteButton() {
        return settingsWindowInTable.$("[data-cream-value='delete']");
    }

    public SelenideElement getSettingsButtonInTable() {
        return settingsButtonInTable;
    }

    public SelenideElement getDialogWindow() {
        return dialogWindow;
    }

    public SelenideElement getAcceptDialogWindow() {
        return dialogWindow.$("[data-cream-action='delete']");
    }

    public SelenideElement getNotesList() {
        return notesList;
    }

}
