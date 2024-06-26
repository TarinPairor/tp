package tutorpro.logic;

import java.nio.file.Path;

import javafx.collections.ObservableList;
import tutorpro.commons.core.GuiSettings;
import tutorpro.logic.commands.CommandResult;
import tutorpro.logic.commands.exceptions.CommandException;
import tutorpro.logic.parser.exceptions.ParseException;
import tutorpro.model.Model;
import tutorpro.model.ReadOnlyAddressBook;
import tutorpro.model.person.Person;
import tutorpro.model.schedule.Reminder;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns the AddressBook.
     *
     * @see Model#getAddressBook()
     */
    ReadOnlyAddressBook getAddressBook();

    /** Returns an unmodifiable view of the filtered list of persons */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns an unmodifiable view of the user's schedule
     */
    ObservableList<Reminder> getTruncatedSchedule();
}
