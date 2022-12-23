package Utilities;

import java.util.UUID;

public class Address {
    // Attributes related to an address
    // attributes are final as an address does not change
    private final int streetNumber;
    private final String streetName, stateOrProvinceName, countryName, cityName, livingArea, schoolDistrict;

    /**
     * copy constructor
     *
     * @param other Address object
     */
    public Address(Address other) {
        this.streetName = other.getStreetName();
        this.streetNumber = other.getStreetNumber();
        this.countryName = other.getCountryName();
        this.stateOrProvinceName = other.getStateOrProvinceName();
        this.livingArea = other.getLivingArea();
        this.schoolDistrict = other.getSchoolDistrict();
        this.cityName = other.getCityName();
    }

    /**
     * constructor defined by required fields to be set
     *
     * @param streetNumber        int recording street number
     * @param streetName          String recording street name
     * @param stateOrProvinceName String recording province or state name
     * @param countryName         String recording country name
     * @param livingArea          String recording the living area of address
     * @param schoolDistrict      String recording the school district of the address
     */
    public Address(int streetNumber,
                   String streetName,
                   String stateOrProvinceName,
                   String countryName,
                   String cityName,
                   String livingArea,
                   String schoolDistrict) {
        if (streetNumber <= 0) throw new IllegalArgumentException("Street number must be a positive integer!");
        else this.streetNumber = streetNumber;
        this.countryName = countryName;
        this.stateOrProvinceName = stateOrProvinceName;
        this.streetName = streetName;
        this.cityName = cityName;
        this.livingArea = livingArea;
        this.schoolDistrict = schoolDistrict;
    }

    /**
     * method for getting the street number of address
     *
     * @return int representing street number
     */
    public int getStreetNumber() {
        return streetNumber;
    }

    /**
     * method for getting the country name of address
     *
     * @return String representing country name
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * method for getting the province or state of the address
     *
     * @return String representing province/state name
     */
    public String getStateOrProvinceName() {
        return stateOrProvinceName;
    }

    /**
     * method for getting the street name of the address
     *
     * @return String representing street name
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * method for getting the living area of the address
     *
     * @return String representing living area
     */
    public String getLivingArea() {
        return livingArea;
    }

    /**
     * method for getting the school district of the address
     *
     * @return String representing the school district
     */
    public String getSchoolDistrict() {
        return schoolDistrict;
    }

    /**
     * method for getting the name of the city of the address
     *
     * @return String reporesenting city name
     */
    public String getCityName() { return cityName; }

    /**
     * method for getting the address in a readable and standard String format
     *
     * @return String representing the official address
     */
    @Override
    public String toString() {
        return this.streetNumber
                + " " + this.streetName
                + ", " + this.cityName
                + ", " + this.stateOrProvinceName
                + ", " + this.countryName;
    }
}