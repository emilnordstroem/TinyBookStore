package domain.models.address;

public class Apartment extends Address{
    private final String floor;
    private final String apartmentNo;

    public Apartment(String streetName, String buildingNo, String postalCode,
                        String city, String country, String floor, String apartmentNo) {
        super(streetName, buildingNo, postalCode, city, country);
        this.floor = floor;
        this.apartmentNo = apartmentNo;
    }

    public String getFloor() {
        return floor;
    }

    public String getApartmentNo() {
        return apartmentNo;
    }
}
