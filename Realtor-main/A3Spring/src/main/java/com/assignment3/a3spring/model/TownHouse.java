package com.assignment3.a3spring.model;

import com.assignment3.a3spring.Utilities.Address;

import java.util.UUID;

public class TownHouse extends House {
    // attributes unique to a Townhouse property
    private int attached;

    /**
     * constructor which will set the uuid
     *
     * @param uuid identification for the property
     */
    public TownHouse(UUID uuid) {
        this.setUuid(uuid);
    }

    /**
     * method for getting the number of houses attached to the TownHouse
     *
     * @return int representing number of attached houses
     */
    public int getAttached() {
        return this.attached;
    }


    /**
     * method for getting the number of houses attached to the Townhouse
     *
     * @param attached int representing number of attached houses
     */
    public void setAttached(int attached) {
        if (attached < 1 || attached > 2)
            throw new IllegalArgumentException("Townhouses must have 1 or 2 houses attatched to them");
        this.attached = attached;
    }

    /**
     * method to continue representing instantiated property's attributes as a String
     * String is continued from House superclass
     *
     * @return string representation of attributes
     */
    @Override
    public String toString() {
        return "TownHouse{" +
                super.toString() +
                ", attached to " + attached + " houses}";
    }

    public static class Builder {
        // required attributes for instantiation
        private UUID uuid;
        private Address address;
        private int bathroomCount, bedroomCount, parkingSpaceCount, floorCount, attached;
        private double price, sizeInSquareMeters;
        private boolean isNewConstruction;

        /**
         * constructor of Builder class to start with implementing the uuid
         *
         * @param uuid identification for the property
         */
        public Builder(UUID uuid) {
            this.uuid = uuid;
        }

        /**
         * method for setting the number of town houses attached
         *
         * @param attached int representing number of attached houses
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder attachedTo(int attached) {
            this.attached = attached;
            return this;
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
         * method for setting the number of floors of the property
         *
         * @param floorCount number of floors of property as int
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder floorsCountedAt(int floorCount) {
            this.floorCount = floorCount;
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
         * method for setting the parkingSpacesCount
         *
         * @param parkingSpaceCount integer for storing the number of parking spaces
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder parkingSpacesCountedAt(int parkingSpaceCount) {
            this.parkingSpaceCount = parkingSpaceCount;
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
         * will create new TownHouse object and set its attributes
         * attributes are set based on that which are set in the Builder class
         * the object with set attributes is then returned
         *
         * @return an object of TownHouse class
         */
        public TownHouse build() {
            TownHouse townHouse = new TownHouse(this.uuid);
            townHouse.setAddress(this.address);
            townHouse.setPrice(this.price);
            townHouse.setBathroomCount(this.bathroomCount);
            townHouse.setBedroomCount(this.bedroomCount);
            townHouse.setParkingSpacesCount(this.parkingSpaceCount);
            townHouse.setSizeInSquareMeters(this.sizeInSquareMeters);
            townHouse.setFloorCount(this.floorCount);
            townHouse.setNewConstruction(this.isNewConstruction);
            townHouse.setAttached(this.attached);
            return townHouse;
        }
    }


}