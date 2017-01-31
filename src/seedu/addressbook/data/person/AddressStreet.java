package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's street number in the Person's address
 * Guarantees: immutable; is valid as declared in {@link #isValid(String)}
 */
public class AddressStreet extends AddressPart {

    public static final String EXAMPLE = "Clementi Ave 3";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Street number can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    
    public AddressStreet(String value) throws IllegalValueException {
        super(value);
    }

    @Override
    public String getExample() {
        return EXAMPLE;
    }

    @Override
    public String getConstraints() {
        return MESSAGE_ADDRESS_CONSTRAINTS;
    }

    @Override
    public String getValidationRegex() {
        return ADDRESS_VALIDATION_REGEX;
    }
}
