package com.assignment3.a3spring.model;

import com.assignment3.a3spring.Utilities.Address;

import java.util.UUID;

public class ParkingLot extends Land {
    // attributes unique to a parking space property
    private String parkingType;
    private int numParkingSpaces, floorCount;
    private boolean isNewConstruction;

    /**
     * constructor which will set the uuid
     *
     * @param uuid identification for the property
     */
    public ParkingLot(UUID uuid) {
        this.setUuid(uuid);
    }

    /**
     * method for setting how many parking space are avilaible for sale on the listing
     * the method must take a numParkingSpaces of more than 1
     * violating this condition will cause an error
     *
     * @param numParkingSpaces integer representing number of parking spots
     */
    public void setNumParkingSpaces(int numParkingSpaces) {
        if (numParkingSpaces <= 1)
            throw new IllegalArgumentException("The lot must include at least one parking space.");
        this.numParkingSpaces = numParkingSpaces;
    }

    /**
     * method for getting the number of parking spaces
     *
     * @return integer representing number of parking spaces for sale
     */
    public int getNumParkingSpaces() {
        return numParkingSpaces;
    }

    /**
     * method for getting the type of parking space (i.e., underground, garage, etc.)
     *
     * @return string representing the type of parking
     */
    public String getParkingType() {
        return parkingType;
    }

    /**
     * method for setting the type of parking space (i.e., underground, garage, etc.)
     *
     * @param parkingType string representing the type of parking
     */
    public void setParkingType(String parkingType) {
        this.parkingType = parkingType;
    }

    /**
     * method for getting whether or not the property is new
     *
     * @return isNewConstruction boolean variable representing if this property is newly constructed
     */

    public boolean isNewConstruction() {
        return isNewConstruction;
    }

    /**
     * method for setting whether or not the property is new
     *
     * @param newConstruction boolean variable representing if this property is newly constructed
     */

    public void setNewConstruction(boolean newConstruction) {
        isNewConstruction = newConstruction;
    }

    /**
     * method to set the number of parking floors
     *
     * @param floorCount int representing number of floors of parking
     */
    public void setFloors(int floorCount) {
        this.floorCount = floorCount;
    }

    /**
     * method to set the number of parking floors
     *
     * @return int representing number of floors of parking
     */
    public int getFloors() {
        return floorCount;
    }

    /**
     * method to continue representing instantiated property's attributes as a String
     *
     * @return string representation of attributes
     */
    @Override
    public String toString() {
        return "ParkingLot{" +
                super.toString() +
                ", parkingType=" + parkingType +
                ", numParkingSpaces=" + numParkingSpaces +
                ", floors=" + floorCount +
                '}';
    }

    /**
     * this class is meant to be instantiated (as its not an abstract)
     * a builder design patterns with all the required attributes is therefore implemented
     * this allows for more simple instantiation for the client
     */
    public static class Builder {
        // required attributes for instantiation
        private UUID uuid;
        private Address address;
        int numParkingSpaces, floorCount;
        String parkingType;
        boolean isNewConstruction;
        double sizeInSquareMeters;

        /**
         * constructor of Builder class to start with implementing the uuid
         *
         * @param uuid identification for the property
         */
        public Builder(UUID uuid) {
            this.uuid = uuid;
        }

        /**
         * method for setting the number of floors of the parking lot
         *
         * @param floorCount int representing number of floors
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder floorsCountedAt(int floorCount) {
            this.floorCount = floorCount;
            return this;
        }

        /**
         * copy made so refrence is not shared by this method which sets the address
         *
         * @param address Address object for setting the address
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder locatedAt(Address address) {
            this.address = address;
            return this;
        }

        /**
         * method for setting the numParkingSpaces
         *
         * @param numParkingSpaces integer for storing the number of parking spaces
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder numParkingSpacesAt(int numParkingSpaces) {
            this.numParkingSpaces = numParkingSpaces;
            return this;
        }

        /**
         * method for setting whether or not the property is new
         *
         * @param isNewConstruction boolean variable representing if this property is newly constructed
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder setAsNewConstruct(boolean isNewConstruction) {
            this.isNewConstruction = isNewConstruction;
            return this;
        }

        /**
         * method for setting the max type of parking space, i.e. underground, garage, etc.
         *
         * @param parkingType string
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder withParkingType(String parkingType) {
            this.parkingType = parkingType;
            return this;
        }

        /**
         * method for setting the size of the property in square meters
         *
         * @param size double representing size of property
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder withSizeInSquareMeters(double size) {
            this.sizeInSquareMeters = size;
            return this;
        }

        /**
         * build method to be called after setting all attributes
         * will create new ParkingLot object and set its attributes
         * attributes are set based on that which are set in the Builder class
         * the object with set attributes is then returned
         *
         * @return an object of ParkingLot class
         */

        public ParkingLot build() {
            ParkingLot parkingLot = new ParkingLot(this.uuid);
            parkingLot.setAddress(this.address);
            parkingLot.setParkingType(this.parkingType);
            parkingLot.setSizeInSquareMeters(this.sizeInSquareMeters);
            parkingLot.setNumParkingSpaces(this.numParkingSpaces);
            parkingLot.setFloors(this.floorCount);
            return parkingLot;
        }
    }
}
