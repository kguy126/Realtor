import Utilities.Address;

import java.util.UUID;


public class Apartment extends Land implements Residential {
    // attributes unique to a apartment property
    private int bathroom = 1;
    private int bedroom = 1;
    private int floorCount;


    private boolean parking;
    // private boolean locker;
    private double price;

    /**
     * @description constructor to set the uuid of the property
     *
     * @param uuid identification for the property
     */
    public Apartment(UUID uuid) {
        this.setUuid(uuid);

    }
    /**
     * method for getting the No. of Bathrooms of the property
     *
     * @return (int)No. of bathrooms
     * */
    @Override
    public int getBathroomCount() {
        return this.bathroom;
    }

    /**
     * method for setting the No. of Bathroom property has
     *
     * @param bathroomCount Bathroom count of the property
     */
    @Override
    public void setBathroomCount(int bathroomCount) {
        this.bathroom=bathroomCount;
    }
    /**
     * method for getting the No. of Bedrooms of the property
     *
     * @return (int)No. of bedrooms
     * */
    @Override
    public int getBedroomCount() {
        return this.bedroom;
    }


    /**
     * method for setting the No. of Bedroom property has
     *
     * @param bedroomCount Bedroom count of the property
     */
    @Override
    public void setBedroomCount(int bedroomCount) {
            this.bedroom = bedroomCount;
    }
    /**
     * method for getting the No. of floors of the property
     *
     * @return (int)No. of Floors
     * */
    @Override
    public int getFloorCount() {
        return this.floorCount;
    }

    /**
     * method for setting the No. of Bathroom property has
     *
     * @param floorCount floor count of the property
     */
    @Override
    public void setFloorCount(int floorCount) {
            this.floorCount = floorCount;
    }
    /**
     * method for getting the price of property
     *
     * @return (Double)Price of the property
     */

    @Override
    public double getPrice() {
        return this.price;
    }

    /**
     * method for setting the No. of Bathroom property has
     *
     * @param price Price of the property
     */
    @Override
    public void setPrice(double price) {

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
     * */
    public void setParking(boolean parking) {
        this.parking = parking;
    }



    public static class Builder {
        // required attributes for instantiation
        private UUID uuid;
        private Address address;
        private int bathroomCount, bedroomCount, floorCount;
        private double price, sizeInSquareMeters;
        private boolean parking;


        /**
         * constructor of Builder class to start with implementing the uuid
         *
         * @param uuid identification for the property
         */
        public Builder(UUID uuid) {
            this.uuid = uuid;
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

        public Builder setBathroomCount(int bathroomCount) {
            this.bathroomCount = bathroomCount;
            return this;
        }

        /**
         * method for setting bedroomCount
         *
         * @param bedroomCount integer for storing num of bedrooms
         * @return the Builder class itself for chaining and easier instantiation
         */

        public Builder setBedroomCount(int bedroomCount) {
            this.bedroomCount = bedroomCount;
            return this;
        }

        /**
         * method for setting price
         *
         * @param price double representing price of property
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }
        /**
         * method for setting the size of the property in square meters
         *
         * @param sizeInSquareMeteres double representing size of property
         * @return the Builder class itself for chaining and easier instantiation
         */

        public Builder setSizeInSquareMeters(double sizeInSquareMeters) {
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
         * build method to be called after setting all attributes
         * will create new Apartment object and set its attributes
         * attributes are set based on that which are set in the Builder class
         * the object with set attributes is then returned
         *
         * @return an object of Apartment class
         */
        public Apartment build() {
            Apartment Apartment = new Apartment(this.uuid);
            Apartment.setAddress(this.address);
            Apartment.setPrice(this.price);
            Apartment.setFloorCount(this.floorCount);
            Apartment.setBathroomCount(this.bathroomCount);
            Apartment.setBedroomCount(this.bedroomCount);
            Apartment.setParking(this.parking);
            Apartment.setSizeInSquareMeters(this.sizeInSquareMeters);

            return Apartment;
        }

        
    }



}
