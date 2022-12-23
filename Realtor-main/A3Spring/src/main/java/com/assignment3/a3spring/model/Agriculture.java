package com.assignment3.a3spring.model;
import com.assignment3.a3spring.Utilities.Address;

import java.util.UUID;

public class Agriculture extends Land{

    //Attributes
    public double price;

    /**
     * this constructor for an Agricultural property sets the uuid and price.
     *
     * @param uuid the parameter is a uuid
     */
    public Agriculture(UUID uuid){
        this.setPrice(200000);// $200,000 is the price
        this.setUuid(uuid);
    }


    /**
     * this method returns the price of the agricultural property.
     * @return the price of the agricultural property.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * setPrice is responsible for setting the price of the agricultural property,
     *
     * @param price parameter is the specified price of the agricultural property, which is greater than 0.
     */
    public void setPrice(double price) {
        if(price <= 0) {

            System.out.println("Error: An Agricultural property has a price greater than 0.");

        }else if (price > 0){
            this.price = price;
        }
    }

    /**
     * The toString() method creates some sort of output for the class.
     * @return a string output of the description of the classes.
     */
    @Override
    public String toString() {
        return "Agricultural Property{" +
                super.toString() + //Gets the super classes to String method to run.
                ", price=" + price +
                '}';
    }

    //A Builder Class. This class allows for this class to be instantiated
    public static class Builder{

        //First, get the Attributes.
        private Address address;
        private UUID uuid;
        private double price, sizeInSquareMeters;

        /**
         * The constructor for this builder class sets the UUID.
         */
        public Builder(UUID uuid) {
            this.uuid = uuid;
        }

        //A Series of Constructors that are crucial to the building process

        /**
         * The builder class will also be responsible to tell the location of the property.
         * @param address address of the property.
         * @return the builder class.
         */
        public Builder locatedAt(Address address) {
            //create the address holder.
            Address a = new Address(address);

            //pass the address holder to this adress
            this.address = a;

            return this;
        }

        /**
         * The builder class will also be responsible to tell the price of the property.
         * @param price double price of the property.
         * @return the builder class.
         */
        public Builder pricedAt(double price) {
            //pass the price holder to this:
            this.price = price;
            return this;
        }

        /**
         * The builder class will also be responsible to tell the size of the property.
         * @param size double size of the property.
         * @return the builder class.
         */
        public Builder withSizeInSquareMeters(double size) {
            this.sizeInSquareMeters = size;
            return this;
        }

        /**
         * Finally, create an object of the class.
         * This is done after setting all attributes.
         * @return a finalized object of the agriculture class.
         */
        public Agriculture build() {
            Agriculture agriculture = new Agriculture(this.uuid);
            agriculture.setAddress(this.address);
            agriculture.setPrice(this.price);
            agriculture.setSizeInSquareMeters(this.sizeInSquareMeters);


            //return a new agriculture object:
            return agriculture;
        }
    }
}



