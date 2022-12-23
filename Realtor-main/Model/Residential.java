package Model;

import Utilities.Address;

public interface Residential {
    // a residential property will contain the following attributes
    int getBathroomCount();

    void setBathroomCount(int bathroomCount);

    int getBedroomCount();

    void setBedroomCount(int bedroomCount);

    int getFloorCount();

    void setFloorCount(int floorCount);

    double getPrice();

    void setPrice(double price);

}


