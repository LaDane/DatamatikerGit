public class Address {
    String streetName;
    int houseNumber;
    String floorNumberAndSide;
    int zipcode;
    String country;

    public Address(String streetName, int houseNumber, String floorNumberAndSide, int zipcode, String country) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.floorNumberAndSide = floorNumberAndSide;
        this.zipcode = zipcode;
        this.country = country;
    }
}
