package model;

import java.util.Set;

public class AddressValidator {

    public boolean isValid(Address address) {
        return this.isCivicAddressValid(address.getAddressLine1())
                && this.isPostalCodeValid(address.getPostalCode());
    }

    public boolean isCivicAddressValid(String address) {
        int firstIndex = address.indexOf(" ");
        int lastIndex = address.lastIndexOf(" ");
        if (firstIndex == lastIndex || firstIndex == -1) {
            return false;
        }
        String houseNbr = address.substring(0, firstIndex);
        boolean isHouseNbrValid = this.isNumberValid(houseNbr);

        String streetType = address.substring(lastIndex + 1, address.length());
        boolean validStreetType = this.isStreetTypeValid(streetType);

        boolean finalResult = isHouseNbrValid && validStreetType;

        return finalResult;
    }

    public boolean isPostalCodeValid(String postalCode) {
        return false;
    }

    private boolean isNumberValid(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isStreetTypeValid(String streetType) {
        Set<String> types = Set.of(
                "St.", "Ave.", "Blvd.", "Dr.", "Rd."
        );

        return types.contains(streetType);
    }
}
