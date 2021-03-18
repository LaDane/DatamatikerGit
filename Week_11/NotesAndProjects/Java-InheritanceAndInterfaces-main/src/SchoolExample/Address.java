package SchoolExample;

public class Address
{
    private String streetName;
    private int houseNumber;
    private int floor;
    private String side;
    private int zipcode;
    private String country;

    public Address(String streetName, int houseNumber, int floor, String side, int zipcode, String country)
    {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.floor = floor;
        this.side = side;
        this.zipcode = zipcode;
        this.country = country;
    }

    public String getStreetName()
    {
        return streetName;
    }

    public int getHouseNumber()
    {
        return houseNumber;
    }

    public int getFloor()
    {
        return floor;
    }

    public String getSide()
    {
        return side;
    }

    public int getZipcode()
    {
        return zipcode;
    }

    public String getCountry()
    {
        return country;
    }

    @Override
    public String toString()
    {
        return streetName + " " + houseNumber + ", " + floor + side + ", " + zipcode + ", " + country;
    }
}
