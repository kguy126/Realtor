package Model;

import Utilities.Address;

import java.util.UUID;

public abstract class Land {
    // common attributes that are shared with all forms of Land
    private UUID uuid;
    private Address address; // reference to address should not be shared
    private double sizeInSquareMeters;

    // Note: of the following methods, the ones declared final are not intended to be overridden

    /**
     * method for getting the size of the land
     *
     * @return size of land in square meters as a double
     */
    public final double getSizeInSquareMeters() {
        return sizeInSquareMeters;
    }

    /**
     * method for setting the size of the land
     *
     * @param sizeInSquareMeters size of the land in square meters
     */
    public final void setSizeInSquareMeters(double sizeInSquareMeters) {
        this.sizeInSquareMeters = sizeInSquareMeters;
    }

    /**
     * Method for getting the land
     *
     * @return a String representing the address at which the land is located
     */
    public final String getAddressString() {
        return address.toString();
    }

    /**
     * returns a copy of address object to avoid privacy leak
     *
     * @return Address object
     */
    public final Address getAddressObj() {
        return new Address(address);
    }

    /**
     * method for setting the address of the land
     * the land has its OWN address (i.e., reference should not be shared)
     * hence, the method implements a copy using the copy constructor of Address class
     *
     * @param address object of Address class
     */
    public final void setAddress(Address address) {
        this.address = new Address(address);
    }

    /**
     * Get the uuid of the property/land
     *
     * @return the UUID of the property/land
     */
    public final UUID getUuid() {
        return uuid;
    }

    /**
     * Set the uuid of the property/land
     *
     * @param uuid the uuid of the property/land
     */
    public final void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * method to continue representing instantiated property's attributes as a String
     * String will be continued by subclasses of Land class as well
     * This because Land class is abstract and not meant to be instantiated
     *
     * @return string representation of attributes
     */
    @Override
    public String toString() {
        return  "uuid=" + uuid +
                ", address= \"" + address.toString() + "\"" +
                ", sizeInSquareMeters=" + sizeInSquareMeters; // to be continued by subclasses
    }
}
