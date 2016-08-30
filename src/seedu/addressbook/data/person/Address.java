package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses needs to be in format of BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = "^\\d+,\\s[\\w\\s]+\\d*,\\s#\\d+-\\d+,\\s\\d{6}$";
    public static final String ADDRESS_SPLITTER = ", ";
    public static final int BLOCK_INDEX = 0;
    public static final int STREET_INDEX = 1;
    public static final int UNIT_INDEX = 2;
    public static final int POSTAL_CODE_INDEX = 3;
    public static final int BLOCK_SUBSTRING_START = 2;
    
    public final String value;
    private Street street;
    private Block block;
    private Unit unit;
    private PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        System.out.println(address);
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        value = address;
        parseAndAssignAddress(address);
    }

    private void parseAndAssignAddress(String address) {
		String[] splittedAddress = address.split(ADDRESS_SPLITTER);
		block = parseBlock(splittedAddress[BLOCK_INDEX]);
		street = new Street(splittedAddress[STREET_INDEX]);
		unit = new Unit(splittedAddress[UNIT_INDEX]);
		postalCode = new PostalCode(Integer.valueOf(splittedAddress[POSTAL_CODE_INDEX]));
	}
    
    Block parseBlock(String block) {
    	return new Block(block.substring(BLOCK_SUBSTRING_START, block.length() - 1));
    }

	/**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    
    public Block getBlock() {
    	return block;
    }
    
    public Street getStreet() {
    	return street;
    }
    
    public Unit getUnit() {
    	return unit;
    }
    
    public PostalCode getPostalCode() {
    	return postalCode;
    }
}