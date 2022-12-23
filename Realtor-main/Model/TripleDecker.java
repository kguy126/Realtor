package Model;

import Utilities.Address;

import java.util.UUID;

public class TripleDecker extends House implements Multifamily {
    // attributes unique to a triple decker property
    private int familyCapacity;

    /**
     * constructor which will set the uuid
     * method will also set the floorCount as 3 as it is a triple decker
     *
     * @param uuid identification for the property
     */
    public TripleDecker(UUID uuid) {
        this.setUuid(uuid);
        this.setFloorCount(3);
    }

    /**
     * method for setting the floorCount
     * setting the floor count to anything other than 3 will give an exception
     * this allows for the constructor to set the floorCount to 3 while not allowing it to be modified from that
     *
     * @param floorCount an integer representing the number of floors
     */
    @Override
    public final void setFloorCount(int floorCount) {
        if (floorCount != 3) throw new IllegalArgumentException(
                "Floor count of triple decker is always 3. This Cannot be changed."
        );
        super.setFloorCount(floorCount); // use setFloorCount in House class only if argument is 3
    }

    /**
     * method for getting the family capacity of the multifamily property
     *
     * @return family capacity represented by an integer
     */
    @Override
    public int getFamilyCapacity() {
        return this.familyCapacity;
    }

    /**
     * method for getting the family capacity of the multifamily property
     *
     * @param familyCapacity family capacity represented by an integer
     */
    @Override
    public void setFamilyCapacity(int familyCapacity) {
        this.familyCapacity = familyCapacity;
    }

    /**
     * method to continue representing instantiated property's attributes as a String
     * String is continued from House superclass
     *
     * @return string representation of attributes
     */
    @Override
    public String toString() {
        return "TripleDecker{" +
                super.toString() +
                ", familyCapacity=" + familyCapacity +
                '}';
    }

    public static class Builder {
        // required attributes for instantiation
        private UUID uuid;
        private Address address;
        private int bathroomCount, bedroomCount, parkingSpaceCount, familyCapacity;
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
         * method for setting the max family count that can be sustained by the multifamily property
         *
         * @param familyCapacity integer representing max family count
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder withFamilyCapacity(int familyCapacity) {
            this.familyCapacity = familyCapacity;
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
         * will create new TripleDecker object and set its attributes
         * attributes are set based on that which are set in the Builder class
         * the object with set attributes is then returned
         * Note: the floorCount is not set in the builder design pattern because it would be redundant
         * this is because the constructor of TripleDecker already ensures it is 3
         *
         * @return an object of TripleDecker class
         */
        public TripleDecker build() {
            TripleDecker tripleDecker = new TripleDecker(this.uuid);
            tripleDecker.setAddress(this.address);
            tripleDecker.setPrice(this.price);
            tripleDecker.setBathroomCount(this.bathroomCount);
            tripleDecker.setBedroomCount(this.bedroomCount);
            tripleDecker.setParkingSpacesCount(this.parkingSpaceCount);
            tripleDecker.setFamilyCapacity(this.familyCapacity);
            tripleDecker.setSizeInSquareMeters(this.sizeInSquareMeters);
            tripleDecker.setNewConstruction(this.isNewConstruction);
            return tripleDecker;
        }
    }
}
