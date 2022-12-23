package Model;
import Utilities.Address;

import java.util.Scanner;
import java.util.UUID;

public class TownHouse extends House {
	// attributes unique to a Townhouse property
	 
	private int familycapacity=1;
	private int attached= 2;
/**
     * constructor which will set the uuid and floor count
     * method will also set the floorCount      *
	* 
     * @param uuid identification for the property
     */
    public TownHouse(UUID uuid, int floorCount) {
        this.setUuid(uuid);
       this.setFloorCount(floorCount); 
	   
    }

    /**
     * method for setting the floorCount
     * floor count has to be in between 2 and 4. Anything else gives an exception
     *
     *
     * @param floorCount an integer representing the number of floors
     */
    @Override
    public final void setFloorCount(int floorCount) {
        if (floorCount <2 ||floorCount>4) throw new IllegalArgumentException(
                "Floor count of triple decker is in between 2 and 4"
        );
        super.setFloorCount(floorCount); // use setFloorCount in House class only if true
    }
    @Override
    public int getFamilyCapacity() {
        return this.familycapacity;
    }
    
    /**returns how many houses are attached to current house*/
public int getattached() {return this.attached;}


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
                "attached to " + attached+
                " houses}";
    }

    public static class Builder {
        // required attributes for instantiation
        private UUID uuid;
        private Address address;
        private int bathroomCount, bedroomCount, parkingSpaceCount, floorCount,familyCapacity;
        private double price, sizeInSquareMeters;
        private boolean isNewConstruction;

        /**
         * constructor of Builder class to start with implementing the uuid and floor count
         *
         * @param uuid identification for the property
         * @param floor count for property
         */
        public Builder(UUID uuid, int floorCount) {
            this.uuid = uuid;
            this.floorCount= floorCount;
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
         * method family count, which is always one
         *
         * @param familyCapacity integer representing family count
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
         * will create new TownHouse object and set its attributes
         * attributes are set based on that which are set in the Builder class
         * the object with set attributes is then returned
         * 
         *
         * @return an object of TownHouse class
         */
        public TownHouse build() {
            TownHouse TownHouse = new TownHouse(this.uuid,this.floorCount);
            TownHouse.setAddress(this.address);
            TownHouse.setPrice(this.price);
            TownHouse.setBathroomCount(this.bathroomCount);
            TownHouse.setBedroomCount(this.bedroomCount);
            TownHouse.setParkingSpacesCount(this.parkingSpaceCount);
            TownHouse.setSizeInSquareMeters(this.sizeInSquareMeters);
            TownHouse.setNewConstruction(this.isNewConstruction);
            return TownHouse;
        }
    }
   
	
}