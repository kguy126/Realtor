package Model;
import Utilities.Address;
import java.util.UUID;

public class Detach extends House {
	// attributes unique to a Detach property
	 
	private int familycapacity=1;
	private int attached= 0;

/**
     * constructor which will set the uuid and floorcount
     * method will also set the floorCount      *
	
     * @param uuid identification for the property
     */
    public Detach(UUID uuid, int floorCount) {
        this.setUuid(uuid);
        this.setFloorCount(floorCount);
	   
    }

    /**
     * method for setting the floorCount
     * floor count can give anything
     * this allows for the constructor to set the floorCount to while not allowing it to be modified from that
     *
     * @param floorCount an integer representing the number of floors
     */
    @Override
    public final void setFloorCount(int floorCount) {        super.setFloorCount(floorCount); // use setFloorCount in House class only if true
    }


    /**
     * method for getting the family capacity of the property
     *
     * @return family capacity represented by an integer
     */    public int getFamilyCapacity() {
        return this.familycapacity;
    }
    /**
     * method to continue representing instantiated property's attributes as a String
     * String is continued from House superclass
     *
     * @return string representation of attributes
     */
    @Override
    public String toString() {
        return "Detach{" +
                super.toString() +"}";
    }

    public static class Builder {
        // required attributes for instantiation
        private UUID uuid;
        private Address address;
        private int bathroomCount, bedroomCount, parkingSpaceCount, familyCapacity,floorCount;
        private double price, sizeInSquareMeters;
        private boolean isNewConstruction;

        /**
         * constructor of Builder class to start with implementing the uuid
         *
         * @param uuid identification for the property
         */
        public Builder(UUID uuid,int floorCount) {
            this.uuid = uuid;
            this.floorCount=floorCount;
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
        public Builder withFamilyCapacity() {
            this.familyCapacity = 1;
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
         * will create new Detach object and set its attributes
         * attributes are set based on that which are set in the Builder class
         * the object with set attributes is then returned
         *
         * @return an object of Detach class
         */
        public Detach build() {
            Detach Detach = new Detach(this.uuid,this.floorCount);
            Detach.setAddress(this.address);
            Detach.setPrice(this.price);
            Detach.setBathroomCount(this.bathroomCount);
            Detach.setBedroomCount(this.bedroomCount);
            Detach.setParkingSpacesCount(this.parkingSpaceCount);
            Detach.setSizeInSquareMeters(this.sizeInSquareMeters);
            Detach.setNewConstruction(this.isNewConstruction);
            return Detach;
        }
    }

}

