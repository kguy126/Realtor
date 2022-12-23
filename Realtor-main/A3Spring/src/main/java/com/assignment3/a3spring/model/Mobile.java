package com.assignment3.a3spring.model;
import com.assignment3.a3spring.Utilities.Address;
import java.util.UUID;

public class Mobile extends House{
    /**
     * this constructor for Mobile Homes sets the uuid and the floor count.
     *
     * @param uuid the parameter is a uuid
     */
    public Mobile(UUID uuid){
        this.setUuid(uuid);
        this.setParkingSpacesCount(0); // mobile homes do not have their own parking
        this.setAddress(new Address()); // does not have static address
    }

    @Override
    public void setParkingSpacesCount(int parkingSpacesCount) {
        if (parkingSpacesCount != 0) {
            throw new IllegalArgumentException("mobile homes do not have their own parking");
        } super.setParkingSpacesCount(parkingSpacesCount);
    }

    /**
     * The toString() method creates some sort of output for the class.
     * @return a string output of the description of the classes.
     */
    @Override
    public String toString() {
        return "Mobile Home{" +
                super.toString() + //Gets the super classes to String method to run.
                '}';
    }
    //A Builder Class. This class allows for this class to be instantiated
    public static class Builder{

        //First, get the Attributes.
        private UUID uuid;
        private boolean isNewConstruction;
        private double price, sizeInSquareMeters;
        private int bathroomCount, bedroomCount, floorCount;

        /**
         * The constructor for this builder class sets the UUID.
         */
        public Builder(UUID uuid) {
            this.uuid = uuid;
        }

        /**
         * The builder class will also be responsible to tell the price of the property.
         * @param price the double price of the property.
         * @return the builder class.
         */
        public Builder pricedAt(double price) {
            //pass the price holder to this:
            this.price = price;
            return this;
        }

        /**
         * The builder class will also be responsible to tell the number of bedrooms in the property.
         * @param bedroomCount the integer number of bedrooms in the property.
         * @return the builder class.
         */
        public Builder bedroomCountedAt(int bedroomCount) {
            this.bedroomCount = bedroomCount;
            return this;
        }

        /**
         * The builder class will also be responsible to tell the number of bathrooms in the property.
         * @param bathroomCount the integer number of bathrooms in the property.
         * @return the builder class.
         */
        public Builder bathroomCountedAt(int bathroomCount) {
            this.bathroomCount = bathroomCount;
            return this;
        }

        /**
         * The builder class will also be responsible to tell if the property is newly constructed.
         * @param isNewConstruction the boolean that tells if the property is a new construction.
         * @return the builder class.
         */
        public Builder setAsNewConstruct(boolean isNewConstruction) {
            this.isNewConstruction = isNewConstruction;
            return this;
        }

        /**
         * The builder class will also be responsible to tell the size of the property.
         * @param size the double size of the property.
         * @return the builder class.
         */
        public Builder withSizeInSquareMeters(double size) {
            this.sizeInSquareMeters = size;
            return this;
        }

        /**
         * method for setting the number of floors
         *
         * @param floorCount the int representing number of floors
         * @return the builder class
         */
        public Builder floorsCountedAt(int floorCount) {
            this.floorCount = floorCount;
            return this;
        }

        /**
         * Finally, create an object of the Mobile property class.
         * This is done after setting all attributes.
         * @return a finalized object of the Mobile homes class.
         */
        public Mobile build() {
            Mobile mobile = new Mobile(this.uuid);

            mobile.setBathroomCount(this.bathroomCount);
            mobile.setBedroomCount(this.bedroomCount);
            mobile.setPrice(this.price);
            mobile.setSizeInSquareMeters(this.sizeInSquareMeters);
            mobile.setNewConstruction(this.isNewConstruction);
            mobile.setFloorCount(this.floorCount);

            //return a new mobile home:
            return mobile;
        }
    }
}