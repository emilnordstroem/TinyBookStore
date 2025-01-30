package domain.models;

public class Address {
    private String streetName;
    private String buildingNo;
    private String postalCode;
    private String city;

    public Address(String streetName, String buildingNo, String postalCode, String city) {
        this.streetName = streetName;
        this.buildingNo = buildingNo;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }
}
