package com.assignment3.a3spring.model;

import com.assignment3.a3spring.Utilities.Address;

import java.util.UUID;

public class LockersAndStorage extends Land {
    // attributes pertaining to lockers and storage properties
    private int floorCount;
    private boolean isHeated, isNewConstruction;
    private double rentalCost;

    /**
     * constructor which will set the uuid
     *
     * @param uuid identification for the property
     */
    public LockersAndStorage(UUID uuid) {
        this.setUuid(uuid);
    }

    /**
     * method for setting the floorCount
     *
     * @param floorCount an integer representing the number of floors
     */
    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    /**
     * method for getting the floor count property
     *
     * @returnfloorcount floor count represented by an integer
     */
    public int getFloorCount() {
        return floorCount;
    }

    /**
     * method for checking if locker is heated
     *
     * @return whether there is heating represented by a boolean
     */

    public boolean isHeated() {
        return isHeated;
    }

    /**
     * method for setting heating status of locker
     *
     * @param heated whether there is heating represented by a boolean
     */

    public void setHeated(boolean heated) {
        isHeated = heated;
    }

    /**
     * method for getting rental cost
     *
     * @return rentalCost cost of rental represented by a double
     */
    public double getRentalCost() {
        return rentalCost;
    }

    /**
     * method for setting rental cost
     * *
     *
     * @param rentalCost cost of rental represented by a double
     */

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    /**
     * method for getting whether or not the property is new
     *
     * @return boolean variable representing if this property is newly constructed
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
     * method to continue representing instantiated property's attributes as a String
     * String is continued from Land superclass
     *
     * @return string representation of attributes
     */
    @Override
    public String toString() {
        return "LockersAndStorage{" +
                super.toString() +
                ", floorCount=" + floorCount +
                ", isHeated=" + isHeated +
                ", isNewConstruction=" + isNewConstruction +
                ", rentalCost=" + rentalCost +
                '}';
    }


    /**
     * this class is meant to be instantiated (as its not an abstract)
     * a builder design patterns with all the required attributes is therefore implemented
     * this allows for more simple instantiation for the client
     */
    public static class Builder {
        // required attribtues for instantiation
        private UUID uuid;
        private Address address;
        private double sizeInSquareMeters, rentalCost;
        private boolean isNewConstruction, isHeated;
        private int floorCount;

        /**
         * constructor of Builder class to start with implementing the uuid
         *
         * @param uuid identification for the property
         */

        public Builder(UUID uuid) {
            this.uuid = uuid;
        }

        /**
         * copy made so reference is not shared by this method which sets the address
         *
         * @param address Address object for setting the address
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder locatedAt(Address address) {
            this.address = new Address(address);
            return this;
        }

        /**
         * method for setting whether or not the locker/storage is a new construction
         *
         * @param newConstruction boolean representing if the storage/locker is a new construction
         * @return he Builder class itself for chaining and easier instantiation
         */
        public Builder setAsNewConstruct(boolean newConstruction) {
            isNewConstruction = newConstruction;
            return this;
        }

        /**
         * method for setting cost
         *
         * @param rentalCost double representing price of property
         * @return the Builder class itself for chaining and easier instantiation
         */

        public Builder costing(double rentalCost) {
            this.rentalCost = rentalCost;
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
         * method for setting if building is heated
         *
         * @param isHeated boolean to check if locker is heated.
         * @return the Builder class itself for chaining and easier instantiation
         */

        public Builder setIsHeated(boolean isHeated) {
            this.isHeated = isHeated;
            return this;
        }

        /**
         * method for setting floorCount
         *
         * @param floorCount integer for storing num of floors
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder floorsCountedAt(int floorCount) {
            this.floorCount = floorCount;
            return this;
        }

        /**
         * build method to be called after setting all attributes
         * will create new LockerAndStorage object and set its attributes
         * attributes are set based on that which are set in the Builder class
         * the object with set attributes is then returned
         *
         * @return an object of ParkingLot class
         */

        public LockersAndStorage build() {
            LockersAndStorage lockersAndStorage = new LockersAndStorage(uuid);
            lockersAndStorage.setAddress(address);
            lockersAndStorage.setSizeInSquareMeters(sizeInSquareMeters);
            lockersAndStorage.setHeated(isHeated);
            lockersAndStorage.setFloorCount(floorCount);
            lockersAndStorage.setNewConstruction(isNewConstruction);
            lockersAndStorage.setRentalCost(rentalCost);
            return lockersAndStorage;
        }


    }


}