package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Abstract class for a type of Contact method for a person in the address book
 * Guarantees: immutable; is valid as declared in {@link #isValid(String)}
 */
public abstract class Contact {

    private final String example;
    private final String messageConstraints;
    private final String validationRegex;
    
    private final String getValue;
    private boolean isPrivate;
    
    public Contact(String example, String messageConstraints, String validationRegex, String value, boolean isPrivate)
            throws IllegalValueException {
        
        // The children classes will set their own final variables
        this.example = example;
        this.messageConstraints = messageConstraints;
        this.validationRegex = validationRegex;
        
        String trimmedValue = value.trim();
        this.isPrivate = isPrivate;
        if (!isValid(trimmedValue)) {
            throw new IllegalValueException(messageConstraints);
        }
        this.getValue = trimmedValue;
    }
    
    /**
     * Returns true if a given string is a valid contact
     */
    public boolean isValid(String test) {
        return test.matches(validationRegex);
    }
    
    public String getExample() {
        return example;
    }

    public String getMessageConstraints() {
        return messageConstraints;
    }

    public String getValidationRegex() {
        return validationRegex;
    }

    public String getValue() {
        return getValue;
    }
    
    @Override
    public String toString() {
        return getValue;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.getValue.equals(((Address) other).getValue())); // state check
    }

    @Override
    public int hashCode() {
        return getValue.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

}
