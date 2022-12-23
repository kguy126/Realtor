package com.assignment3.a3spring.Utilities;

import com.assignment3.a3spring.model.Land;

import java.util.*;

/**
 * Singleton storage system for records of properties
 */
public class MultipleListingService {
    private static Map<UUID, Land> storage; // hashmap for storing properties
    private static volatile MultipleListingService instance = null; // volatile instance of class
    // Note: volatile keyword is used to help ensure thread safety to avoid unpredictable outcomes

    /**
     * only constructor to be private in order to prevent instantiation
     * this class is not intended to be instantiated
     */
    private MultipleListingService() {
    }

    /**
     * method for getting instance to this class
     * method will only create instance if one has not already been created
     * the instance will then be returned
     *
     * @return instance of the MultipleListingService class
     */
    public static MultipleListingService getInstance() {
        if (instance == null) {
            synchronized (MultipleListingService.class) {
                // double clutching to ensure thread safety
                if (instance == null) {
                    instance = new MultipleListingService();
                    storage = Collections.synchronizedMap(new HashMap<UUID, Land>());
                }
            }
        }
        return instance;
    }

    /**
     * method for adding a new property to storage
     *
     * @param property object of Land class to be added to the storage of instantiated properties
     */
    public void addNewProperty(Land property) {
        storage.put(property.getUuid(), property);
    }

    /**
     * method for removing a property from storage
     *
     * @param uuid identification for the property to remove
     */
    public void removeProperty(UUID uuid) {
        storage.remove(uuid);
    }

    /**
     * method for finding a property in storage with specific uuid
     *
     * @param uuid search reference for finding a specific property
     * @return the Land object of the property that matches search reference
     */
    public Land searchById(UUID uuid) {
        return storage.getOrDefault(uuid, null); // return null if no property found
    }

    /**
     * method for getting a list of properties within a certain square meter size range
     *
     * @param min minimum size to look for as a double
     * @param max maximum size to look for as a double
     * @return An array of
     */
    public ArrayList<Land> searchBySize(double min, double max) {
        ArrayList<Land> result = new ArrayList<Land>();
        for (UUID key : storage.keySet()) {
            if (storage.get(key).getSizeInSquareMeters() >= min && storage.get(key).getSizeInSquareMeters() <= max)
                result.add(storage.get(key));
        }
        if (result.size() == 0) return null; // return null if no properties found
        return result;
    }

    /**
     * method for getting a list of properties that are in a certain country
     *
     * @param country country String for search reference
     * @return the land object of the property that matches search reference
     */
    public ArrayList<Land> searchByCountry(String country) {
        ArrayList<Land> result = new ArrayList<Land>();
        for (UUID key : storage.keySet()) {
            if (storage.get(key).getAddressObj().getCountryName().equals(country))
                result.add(storage.get(key));
        }
        if (result.size() == 0) return null; // return null if no properties found
        return result;
    }

    /**
     * method for getting a list of properties that are in a certain province or state
     *
     * @param provinceOrState province or state String for search reference
     * @return the land object of the property that matches search reference
     */
    public ArrayList<Land> searchByProvinceOrState(String provinceOrState) {
        ArrayList<Land> result = new ArrayList<Land>();
        for (UUID key : storage.keySet()) {
            if (storage.get(key).getAddressObj().getStateOrProvinceName().equals(provinceOrState))
                result.add(storage.get(key));
        }
        if (result.size() == 0) return null; // return null if no properties found
        return result;
    }

    /**
     * method for getting a list of properties that are in a certain city
     *
     * @param city city String for search reference
     * @return the land object of the property that matches search reference
     */
    public ArrayList<Land> searchByCity(String city) {
        ArrayList<Land> result = new ArrayList<Land>();
        for (UUID key : storage.keySet()) {
            if (storage.get(key).getAddressObj().getCityName().equals(city))
                result.add(storage.get(key));
        }
        if (result.size() == 0) return null; // return null if no properties found
        return result;
    }
}