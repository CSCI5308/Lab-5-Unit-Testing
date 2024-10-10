import model.Address;
import model.AddressValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class AddressValidatorTest {

    private AddressValidator validator;

    @BeforeEach
    void setUp() {
        validator = new AddressValidator();
    }

    @Test
    public void testCivicAddressStartWithNumber() {
        Address address = new Address(1,
                "6050 University Ave.",
                "Halifax",
                "NS",
                "B3H 1W5",
                null);
        boolean validCivicAddress = validator.isCivicAddressValid(address.getAddressLine1());
        assertTrue(validCivicAddress, "Civic address should be valid");
    }

    @Test
    public void testCivicAddressStartWithLetter() {
        String addressLine1 = "A050 University Ave.";
        boolean validCivicAddress = validator.isCivicAddressValid(addressLine1);
        assertFalse(validCivicAddress, "Civic address should be invalid");
    }

    @Test
    public void testCivicAddressWithOnlyHouseNumber() {
        String addressLine1 = "@6050";
        boolean validCivicAddress = validator.isCivicAddressValid(addressLine1);
        assertFalse(validCivicAddress, "Civic address should be invalid");
    }

    @Test
    public void testCivicAddressWithHouseNumberWithSpace() {
        // TODO: Write a test case to check if civic address is invalid when house number contains space
    }

    @Test
    public void testCivicAddressWithInvalidStreetType() {
        String addressLine1 = "6050 University ZYX.";
        boolean validCivicAddress = validator.isCivicAddressValid(addressLine1);
        assertTrue(validCivicAddress, "Civic address should be invalid");
    }
}