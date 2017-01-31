package seedu.addressbook.data.person;

import java.util.HashMap;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: the individual parts are immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = AddressBlock.EXAMPLE + "," 
                                    + AddressStreet.EXAMPLE + "," + AddressUnit.EXAMPLE + ","
                                    + AddressPostalCode.EXAMPLE;
    
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Address should have four components split by comma";
    // Note that the address parts will also check validity in their own classes
    public static final String ADDRESS_VALIDATION_REGEX = ".+,.+,.+,.+";
    public static final String ADDRESS_SPLIT_WORD = ", ";
    
    public enum EnumAddressPart {
        BLOCK(0), STREET(1), UNIT(2), POSTAL_CODE(3);
        
        public final int id;
        EnumAddressPart(int id) {
            this.id = id;
          }
    }
    public final String value;

    private HashMap<EnumAddressPart, AddressPart> addressParts;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        String[] splitAddressComponents = trimmedAddress.split(ADDRESS_SPLIT_WORD);
        // Creating the address using address parts
        addressParts = new HashMap<EnumAddressPart, AddressPart>();
        
        AddressBlock block = new AddressBlock(splitAddressComponents[EnumAddressPart.BLOCK.id]);
        addressParts.put(EnumAddressPart.BLOCK, block);
        
        AddressStreet street = new AddressStreet(splitAddressComponents[EnumAddressPart.STREET.id]);
        addressParts.put(EnumAddressPart.STREET, street);
        
        AddressUnit unit = new AddressUnit(splitAddressComponents[EnumAddressPart.UNIT.id]);
        addressParts.put(EnumAddressPart.UNIT, unit);
        
        AddressPostalCode postalCode = new AddressPostalCode(splitAddressComponents[EnumAddressPart.POSTAL_CODE.id]);
        addressParts.put(EnumAddressPart.POSTAL_CODE, postalCode);
        
        value = this.toString();
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return addressParts.get(EnumAddressPart.BLOCK) + ADDRESS_SPLIT_WORD
                + addressParts.get(EnumAddressPart.STREET) + ADDRESS_SPLIT_WORD
                + addressParts.get(EnumAddressPart.UNIT) + ADDRESS_SPLIT_WORD
                + addressParts.get(EnumAddressPart.POSTAL_CODE);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.addressParts.equals(((Address) other).addressParts)); // state check
    }

    @Override
    public int hashCode() {
        return addressParts.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
