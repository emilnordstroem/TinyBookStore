package domain.models.address;

public abstract class Address {
    protected String streetName;
    protected String buildingNo;
    protected String postalCode;
    protected String city;
    protected String country;

    protected Address(String streetName, String buildingNo, String postalCode, String city, String country) {
        this.streetName = streetName;
        this.buildingNo = buildingNo;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }
}
