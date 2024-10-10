package model;

public class Address {

    private int id;

    private String addressLine1;
    private String city;
    private String province;
    private String postalCode;

    private Customer customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Address() {
    }

    public Address(int id, String addressLine1, String city, String province, String postalCode, Customer customer) {
        this.id = id;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.customer = customer;
    }
}

