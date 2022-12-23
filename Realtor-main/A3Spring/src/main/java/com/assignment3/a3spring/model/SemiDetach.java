package com.assignment3.a3spring.model;

import com.assignment3.a3spring.Utilities.Address;

import java.util.UUID;

public class SemiDetach extends House {
    // attributes unique to a SemiDetach property
    private boolean separateParking;

    /**
     * constructor which will set the uuid
     *
     * @param uuid identification for the property
     */
    public SemiDetach(UUID uuid, int floorCount) {
        this.setUuid(uuid);
    }

    /**
     * method for getting if house has its own parking space separate from the attached semi detach home
     *
     * @return boolean representing if property has separate parking
     */
    public boolean hasSeparateParking() {
        return this.separateParking;
    }

    /**
     * method for getting if house has its own parking space separate from the attached semi detach home
     *
     * @param separateParking boolean representing if property has separate parking
     */
    public void setSeparateParking(boolean separateParking) {
        this.separateParking = separateParking;
    }

    /**
     * method to continue representing instantiated property's attributes as a String
     * String is continued from House superclass
     *
     * @return string representation of attributes
     */
    @Override
    public String toString() {
        return "SemiDetach{" +
                super.toString() +
                ", seperateParking=" + this.separateParking + "}";
    }

    public static class Builder {
        // required attributes for instantiation
        private UUID uuid;
        private Address address;
        private int bathroomCount, bedroomCount, parkingSpaceCount, floorCount;
        private double price, sizeInSquareMeters;
        private boolean isNewConstruction, hasSeparateParking;

        /**
         * constructor of Builder class to start with implementing the uuid
         *
         * @param uuid identification for the property
         */
        public Builder(UUID uuid) {
            this.uuid = uuid;
        }

        /**
         * method for setting the number of floors of the property
         *
         * @param floorCount int representing number of floors of the property
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder floorsCountedAt(int floorCount) {
            this.floorCount = floorCount;
            return this;
        }

        /**
         * method for setting if the property has separate parking from that of the attached semi detach
         *
         * @param hasSeparateParking boolean representing if the property has separate parking
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder setHasSeparateParking(boolean hasSeparateParking) {
            this.hasSeparateParking = hasSeparateParking;
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
         * @returnthe Builder class itself for chaining and easier instantiation
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
         * will create new SemiDetach object and set its attributes
         * attributes are set based on that which are set in the Builder class
         * the object with set attributes is then returned
         *
         * @return an object of SemiDetach class
         */
        public SemiDetach build() {
            SemiDetach semiDetach = new SemiDetach(this.uuid, this.floorCount);
            semiDetach.setAddress(this.address);
            semiDetach.setPrice(this.price);
            semiDetach.setBathroomCount(this.bathroomCount);
            semiDetach.setBedroomCount(this.bedroomCount);
            semiDetach.setParkingSpacesCount(this.parkingSpaceCount);
            semiDetach.setSizeInSquareMeters(this.sizeInSquareMeters);
            semiDetach.setNewConstruction(this.isNewConstruction);
            semiDetach.setFloorCount(this.floorCount);
            semiDetach.setSeparateParking(this.hasSeparateParking);
            return semiDetach;
        }
    }


}