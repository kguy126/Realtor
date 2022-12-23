package Utilities;

import Model.Land;

import java.util.*;

/**
 * Singleton Caching system
 */
public class Cache {
    // only one private constructor to avoid instantiation
    private Cache() { }

    // capacity of the caching system to not be exceeded
    public final static int CAPACITY = 9999;

    // cache storage implemented as a Map (to be later defined as LinkedHashMap)
    private static Map<UUID, Land> cache;

    // instance of this class initially set as null
    private static Cache instance = null;

    /**
     * method for getting instance to this class
     * method will only create instance if one has not already been created
     * the instance will then be returned
     *
     * @return instance of the Cache class
     */
    public static Cache getInstance() {
        if (instance == null) {
            synchronized (Cache.class) {
                // double clutching to ensure thread safety
                if (instance == null)
                    instance = new Cache();
                    cache = Collections.synchronizedMap(new LinkedHashMap<UUID, Land>() {
                        /**
                         * method implementation modified to return true if size exceeds capacity
                         * overriding this method is to ensure eldest entry of map is removed upon exceeding
                         * the max capacity of the caching system defined by CAPACITY
                         * I.e., method returns true=>eldest entry is removed. Hence it returns true if size>capacity
                         *
                         * this ability is also the motivation for the use of a LinkedHashMap as
                         * opposed to a regular HashMap
                         *
                         * @param eldest least recent entry of the map (to be removed if method returns true)
                         * @return whether the current size has exceeded capacity
                         */
                        @Override
                        protected boolean removeEldestEntry(Map.Entry<UUID, Land> eldest) {
                            return size() > CAPACITY;
                        }
                    });
            }
        } return instance;
    }

    /**
     * methods below are similar to that of the class containing original storage
     * efficiency is however improved as a result of caching (having less to iterate through)
     */

    /**
     * method for adding a new property to storage
     *
     * @param property object of Land class to be added to the storage of instantiated properties
     */
    public void addNewProperty(Land property) {
        cache.put(property.getUuid(), property);
    }

    /**
     * method for removing a property from storage
     *
     * @param uuid identification for the property to remove
     */
    public void removeProperty(UUID uuid) {
        cache.remove(uuid);
    }

    /**
     * method for finding a property in storage with specific uuid
     *
     * @param uuid search reference for finding a specific property
     * @return the Land object of the property that matches search reference
     */
    public Land searchById(UUID uuid) {
        return cache.getOrDefault(uuid, null); // return null if no property found
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
        for (UUID key : cache.keySet()) {
            if (cache.get(key).getSizeInSquareMeters() >= min && cache.get(key).getSizeInSquareMeters() <= max)
                result.add(cache.get(key));
        } if (result.size() == 0) return null; // return null if no properties found
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
        for (UUID key: cache.keySet()) {
            if (cache.get(key).getAddressObj().getCountryName().equals(country))
                result.add(cache.get(key));
        } if (result.size() == 0) return null; // return null if no properties found
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
        for (UUID key: cache.keySet()) {
            if (cache.get(key).getAddressObj().getStateOrProvinceName().equals(provinceOrState))
                result.add(cache.get(key));
        } if (result.size() == 0) return null; // return null if no properties found
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
        for (UUID key: cache.keySet()) {
            if (cache.get(key).getAddressObj().getCityName().equals(city))
                result.add(cache.get(key));
        } if (result.size() == 0) return null; // return null if no properties found
        return result;
    }



}
