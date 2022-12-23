package com.assignment3.a3spring.model;

import com.assignment3.a3spring.Utilities.Address;

import java.util.UUID;

public class Apartment extends Land implements Residential {
    // attributes unique to a apartment property
    private boolean parking; // apartments either have or dont have a parking lot that can hold many cars
    private boolean isCoop, isNewConstruct;
    private int bathroomCount, bedroomCount, floorCount;
    private double price;

    /**
     * @param uuid identification for the property
     * @description constructor to set the uuid of the property
     */
    public Apartment(UUID uuid) {
        this.setUuid(uuid);
    }

    /**
     * method for checking if parking is available with the property
     *
     * @return (Boolean) Parking availability
     */
    public boolean isParking() {
        return parking;
    }

    /**
     * method for setting the parkingSpacesCount
     *
     * @param parking boolean for storing if parking is available.
     */
    public void setParking(boolean parking) {
        this.parking = parking;
    }

    /**
     * method for getting whether this is a cooperative home/apartment
     *
     * @return boolean representing whether this is a cooperative apartment
     */
    public boolean isCoop() {
        return isCoop;
    }

    /**
     * method for setting whether this is a cooperative home/apartment
     *
     * @param coop boolean representing whether this is a cooperative apartment
     */
    public void setCoop(boolean coop) {
        isCoop = coop;
    }

    @Override
    public String toString() {
        return isCoop ? "Coop Apartment" : "Condo{" +
                super.toString() +
                ", hasParking=" + parking +
                ", isNewConstruct=" + isNewConstruct +
                ", bathroomCount=" + bathroomCount +
                ", bedroomCount=" + bedroomCount +
                ", floorCount=" + floorCount +
                ", price=" + price +
                '}';
    }

    /**
     * method for getting the number of bathrooms in a standard apartment unit
     *
     * @return int representing number of bathrooms
     */
    @Override
    public int getBathroomCount() {
        return bathroomCount;
    }

    /**
     * method for setting the number of bathrooms in a standard apartment unit
     *
     * @param bathroomCount int representing number of bathrooms
     */
    @Override
    public void setBathroomCount(int bathroomCount) {
        this.bathroomCount = bathroomCount;
    }

    /**
     * method for getting the number of bedrooms in a standard apartment unit
     *
     * @return int representing number of bedrooms
     */
    @Override
    public int getBedroomCount() {
        return bedroomCount;
    }

    /**
     * method for setting the number of bedrooms in a standard apartment unit
     *
     * @param bedroomCount int representing the number of bedrooms
     */
    @Override
    public void setBedroomCount(int bedroomCount) {
        this.bedroomCount = bedroomCount;
    }

    /**
     * method for getting the standard number of floors for apartment unit
     *
     * @return int representing the number of floors
     */
    @Override
    public int getFloorCount() {
        return floorCount;
    }

    /**
     * methof for setting the standard number of floors for apartment unit
     *
     * @param floorCount int representing the number of floors
     */
    @Override
    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    /**
     * method for getting price
     *
     * @return double representing price of apartment unit
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * method for setting price
     *
     * @param price double representing price of apartment unit
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * method for getting if the apartment is a new construct
     *
     * @return boolean representing if the apartment is newly built
     */
    public boolean isNewConstruct() {
        return isNewConstruct;
    }

    /**
     * method for getting if the apartment is a new construct
     *
     * @param newConstruct boolean representing if the apartment is newly built
     */
    public void setNewConstruct(boolean newConstruct) {
        isNewConstruct = newConstruct;
    }

    public static class Builder {
        // required attributes for instantiation
        private UUID uuid;
        private Address address;
        private int bathroomCount, bedroomCount, floorCount;
        private double price, sizeInSquareMeters;
        private boolean parking, isCoop, isNewConstruct;


        /**
         * constructor of Builder class to start with implementing the uuid
         *
         * @param uuid identification for the property
         */
        public Builder(UUID uuid) {
            this.uuid = uuid;
        }

        /**
         * @param floorCount int representing number of floors
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder floorsCountedAt(int floorCount) {
            this.floorCount = floorCount;
            return this;
        }

        /**
         * method for setting whether this is a cooperative home/apartment
         *
         * @param coop boolean representing whether this is a cooperative apartment
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder setCoop(boolean coop) {
            isCoop = coop;
            return this;
        }

        /**
         * copy made so refrence is not shared by this method which sets the address
         *
         * @param address Address object for setting the address
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder locatedAt(Address address) {
            this.address = new Address(address);
            return this;
        }

        /**
         * method for setting bathroomCount
         *
         * @param bathroomCount integer for storing num of bathrooms
         * @return the Builder class itself for chaining and easier instantiation
         */

        public Builder bathroomCountedAt(int bathroomCount) {
            this.bathroomCount = bathroomCount;
            return this;
        }

        /**
         * method for setting price
         *
         * @param price double representing price of property
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder pricedAt(double price) {
            this.price = price;
            return this;
        }

        /**
         * method for setting bedroomCount
         *
         * @param bedroomCount integer for storing num of bedrooms
         * @return the Builder class itself for chaining and easier instantiation
         */

        public Builder bedroomCountedAt(int bedroomCount) {
            this.bedroomCount = bedroomCount;
            return this;
        }

        /**
         * method for setting the size of the property in square meters
         *
         * @param sizeInSquareMeters double representing size of property
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder withSizeInSquareMeters(double sizeInSquareMeters) {
            this.sizeInSquareMeters = sizeInSquareMeters;
            return this;
        }

        /**
         * method for setting the parkingSpacesCount
         *
         * @param parking boolean for storing if parking is available.
         * @return the Builder class itself for chaining and easier instantiation
         */

        public Builder setParking(boolean parking) {
            this.parking = parking;
            return this;
        }

        /**
         * method for setting if the apartment is a new construct
         *
         * @param isNewConstruct boolean representing if the apartment is newly built
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder setAsNewConstruct(boolean isNewConstruct) {
            this.isNewConstruct = isNewConstruct;
            return this;
        }

        /**
         * build method to be called after setting all attributes
         * will create new Apartment object and set its attributes
         * attributes are set based on that which are set in the Builder class
         * the object with set attributes is then returned
         *
         * @return an object of Apartment class
         */
        public Apartment build() {
            Apartment apartment = new Apartment(this.uuid);
            apartment.setAddress(this.address);
            apartment.setPrice(this.price);
            apartment.setFloorCount(this.floorCount);
            apartment.setBathroomCount(this.bathroomCount);
            apartment.setBedroomCount(this.bedroomCount);
            apartment.setNewConstruct(this.isNewConstruct);
            apartment.setCoop(this.isCoop);
            apartment.setParking(this.parking);

            apartment.setSizeInSquareMeters(this.sizeInSquareMeters);

            return apartment;
        }


    }


}