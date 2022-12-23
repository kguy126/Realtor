package com.assignment3.a3spring.model;
import com.assignment3.a3spring.Utilities.Address;
import java.util.UUID;

public class Multiplex extends House  implements Multifamily{
    // attributes unique to a multiplex property
    private int plexCount, familyCapacity;

    /**
     * constructor to set the uuid of the property
     *
     * @param uuid identification for the property
     */
    public Multiplex(UUID uuid) {
        this.setUuid(uuid);
    }

    /**
     * method for setting how many "plex" the multiplex consists of
     * e.g., plex=2 indicates duplex, plex=4 indicates quadruplex, etc.
     * the method must take a plexCount of more than 1 (else it defeats the purpose and meaning of a "multiplex")
     * violating this condition will cause an error
     *
     * @param plexCount integer representing how many parts the multiplex consists of
     */
    public void setPlexCount(int plexCount) {
        if (plexCount <= 1) throw new IllegalArgumentException("A multiplex consists of more than 1 section");
        this.plexCount = plexCount;
    }

    /**
     * method for getting the type of multiplex (i.e., duplex, triplex, quadruplex, etc.)
     *
     * @return integer representing number of parts of multiplex
     */
    public int getPlexCount() {
        return plexCount;
    }

    /**
     * method for getting the capacity for numbers of families the multifamily property can ideally hold
     *
     * @return integer representing the capacity for numbers of families
     */
    @Override
    public int getFamilyCapacity() {
        return familyCapacity;
    }

    /**
     * method for setting the capacity for numbers of families the multifamily property can ideally hold
     *
     * @param familyCapacity integer representing the capacity for numbers of families
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
        return  this.plexCount + "plex{" +
                super.toString() +
                ", familyCapacity=" + familyCapacity +
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
        private int bathroomCount, bedroomCount, floorCount, parkingSpaceCount, plexCount, familyCapacity;
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
         * method for setting the floorCount
         *
         * @param floorCount integer for storing the num of floors
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder floorsCountedAt(int floorCount) {
            this.floorCount = floorCount;
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
         * method for setting number of multiplex sections
         *
         * @param plexCount integer representing the number of sections of multiplex
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder plexesCountedAt(int plexCount) {
            this.plexCount = plexCount;
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
         * will create new Multiplex object and set its attributes
         * attributes are set based on that which are set in the Builder class
         * the object with set attributes is then returned
         *
         * @return an object of Multiplex class
         */
        public Multiplex build() {
            Multiplex multiplex = new Multiplex(this.uuid);
            multiplex.setAddress(this.address);
            multiplex.setPrice(this.price);
            multiplex.setFloorCount(this.floorCount);
            multiplex.setBathroomCount(this.bathroomCount);
            multiplex.setBedroomCount(this.bedroomCount);
            multiplex.setParkingSpacesCount(this.parkingSpaceCount);
            multiplex.setPlexCount(this.plexCount);
            multiplex.setFamilyCapacity(this.familyCapacity);
            multiplex.setSizeInSquareMeters(this.sizeInSquareMeters);
            multiplex.setNewConstruction(this.isNewConstruction);
            return multiplex;
        }
    }
}