package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's block number in the Person's address
 * Guarantees: immutable; is valid as declared in {@link #isValid(String)}
 */
public class AddressBlock extends AddressPart {

    public static final String EXAMPLE = "123";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Block number can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    
    public AddressBlock(String value) throws IllegalValueException {
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
