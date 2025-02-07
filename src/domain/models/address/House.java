package domain.models.address;

public class House extends Address{
    private final String gateCode;

    public House(String streetName, String buildingNo, String postalCode,
                 String city, String country, String gateCode) {
        super(streetName, buildingNo, postalCode, city, country);
        this.gateCode = gateCode;
    }

    public String getGateCode() {
        return gateCode;
    }
}
