package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * A part of the Person's address
 * Guarantees: immutable; is valid as declared in {@link #isValid(String)}
 */
public abstract class AddressPart {

    private final String value;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public AddressPart(String value) throws IllegalValueException {
        String trimmedString = value.trim();
        if (!isValid(trimmedString)) {
            throw new IllegalValueException(getConstraints());
        }
        this.value = trimmedString;
    }
    
    public abstract String getExample();
    public abstract String getConstraints();
    public abstract String getValidationRegex();
    
    /**
     * Returns value of the address part that is immutable
     */
    public String getValue(String test) {
        return value;
    }

    /**
     * Returns true if a given string is a valid address part 
     * according to the validation regex
     */
    public boolean isValid(String test) {
        return test.matches(getValidationRegex());
    }
    
    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddressPart // instanceof handles nulls
                && this.value.equals(((AddressPart) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
