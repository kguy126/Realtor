package com.assignment3.a3spring;

import com.assignment3.a3spring.Utilities.*;
import com.assignment3.a3spring.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@SpringBootApplication
public class A3SpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(A3SpringApplication.class, args);
    }

    /**
     * FOR METHODS BELOW
     * parameters include all required attributes which will be grabbed from html forms
     * after taken from html the create methods will instantiate the desired properties
     * the searching methods will find the properties using the caching system first, and then main storage
     * the delete methods will remove the desired properties from both the cache and main storage
     * the modify / mod methods will reassign specific properties to a property with the specific uuid
     *
     * all will return a string to the user with a link to the homepage for continuing to use the application
     */

    @RequestMapping(value = "/multiplex", method = RequestMethod.POST)
    public String multiplex(@RequestParam("streetNum") int streetNum,
                            @RequestParam("streetName") String streetName,
                            @RequestParam("city") String city,
                            @RequestParam("country") String country,
                            @RequestParam("provstate") String provstate,
                            @RequestParam("living") String living,
                            @RequestParam("district") String district,
                            @RequestParam("price") double price,
                            @RequestParam("size") double size,
                            @RequestParam("floors") int floors,
                            @RequestParam("bath") int bath,
                            @RequestParam("bed") int bed,
                            @RequestParam("parking") int parking,
                            @RequestParam("plex") int plex,
                            @RequestParam("fam") int fam,
                            @RequestParam("isNew") String isNew) {

        UUID uuid = UUID.randomUUID();
        MultipleListingService instance = MultipleListingService.getInstance();
        Multiplex property = new Multiplex.Builder(uuid)
                .locatedAt(new Address(streetNum, streetName, provstate, country, city, living, district))
                .pricedAt(price)
                .withSizeInSquareMeters(size)
                .floorsCountedAt(floors)
                .bathroomCountedAt(bath)
                .bedroomCountedAt(bed)
                .parkingSpacesCountedAt(parking)
                .plexesCountedAt(plex)
                .withFamilyCapacity(fam)
                .setAsNewConstruct(isNew.equals("yes"))
                .build();
        instance.addNewProperty(property);

        return createdMessage(property.toString());
    }

    @RequestMapping(value = "/tripled", method = RequestMethod.POST)
    public String tripled(@RequestParam("streetNum") int streetNum,
                          @RequestParam("streetName") String streetName,
                          @RequestParam("city") String city,
                          @RequestParam("country") String country,
                          @RequestParam("provstate") String provstate,
                          @RequestParam("living") String living,
                          @RequestParam("district") String district,
                          @RequestParam("price") double price,
                          @RequestParam("size") double size,
                          @RequestParam("bath") int bath,
                          @RequestParam("bed") int bed,
                          @RequestParam("parking") int parking,
                          @RequestParam("fam") int fam,
                          @RequestParam("isNew") String isNew) {

        UUID uuid = UUID.randomUUID();
        MultipleListingService instance = MultipleListingService.getInstance();
        TripleDecker property = new TripleDecker.Builder(uuid)
                .locatedAt(new Address(streetNum, streetName, provstate, country, city, living, district))
                .pricedAt(price)
                .withSizeInSquareMeters(size)
                .bathroomCountedAt(bath)
                .bedroomCountedAt(bed)
                .parkingSpacesCountedAt(parking)
                .withFamilyCapacity(fam)
                .setAsNewConstruct(isNew.equals("yes"))
                .build();
        instance.addNewProperty(property);

        return createdMessage(property.toString());
    }

    @RequestMapping(value = "/agriculture", method = RequestMethod.POST)
    public String agriculture(@RequestParam("streetNum") int streetNum,
                              @RequestParam("streetName") String streetName,
                              @RequestParam("city") String city,
                              @RequestParam("country") String country,
                              @RequestParam("provstate") String provstate,
                              @RequestParam("price") double price,
                              @RequestParam("size") double size) {

        UUID uuid = UUID.randomUUID();
        MultipleListingService instance = MultipleListingService.getInstance();
        String living = "N/A", district = "N/A";
        Agriculture property = new Agriculture.Builder(uuid)
                .locatedAt(new Address(streetNum, streetName, provstate, country, city, living, district))
                .pricedAt(price)
                .withSizeInSquareMeters(size)
                .build();
        instance.addNewProperty(property);

        return createdMessage(property.toString());
    }

    @RequestMapping(value = "/mobile", method = RequestMethod.POST)
    public String mobile(@RequestParam("price") double price,
                         @RequestParam("size") double size,
                         @RequestParam("bath") int bath,
                         @RequestParam("bed") int bed,
                         @RequestParam("floors") int floors,
                         @RequestParam("isNew") String isNew) {

        UUID uuid = UUID.randomUUID();
        MultipleListingService instance = MultipleListingService.getInstance();
        Mobile property = new Mobile.Builder(uuid)
                .pricedAt(price)
                .withSizeInSquareMeters(size)
                .bathroomCountedAt(bath)
                .bedroomCountedAt(bed)
                .setAsNewConstruct(isNew.equals("yes"))
                .floorsCountedAt(floors)
                .build();
        instance.addNewProperty(property);

        return createdMessage(property.toString());
    }

    @RequestMapping(value = "/apartment", method = RequestMethod.POST)
    public String apartment(@RequestParam("streetNum") int streetNum,
                            @RequestParam("streetName") String streetName,
                            @RequestParam("city") String city,
                            @RequestParam("country") String country,
                            @RequestParam("provstate") String provstate,
                            @RequestParam("living") String living,
                            @RequestParam("district") String district,
                            @RequestParam("price") double price,
                            @RequestParam("size") double size,
                            @RequestParam("floors") int floors,
                            @RequestParam("bath") int bath,
                            @RequestParam("bed") int bed,
                            @RequestParam("parking") String parking,
                            @RequestParam("isNew") String isNew,
                            @RequestParam("isCoop") String isCoop) {

        UUID uuid = UUID.randomUUID();
        MultipleListingService instance = MultipleListingService.getInstance();
        Apartment property = new Apartment.Builder(uuid)
                .locatedAt(new Address(streetNum, streetName, provstate, country, city, living, district))
                .pricedAt(price)
                .withSizeInSquareMeters(size)
                .floorsCountedAt(floors)
                .bathroomCountedAt(bath)
                .bedroomCountedAt(bed)
                .setParking(parking.equals("yes"))
                .setAsNewConstruct(isNew.equals("yes"))
                .setCoop(isCoop.equals("yes"))
                .build();
        instance.addNewProperty(property);

        return createdMessage(property.toString());
    }

    @RequestMapping(value = "/town", method = RequestMethod.POST)
    public String town(@RequestParam("streetNum") int streetNum,
                       @RequestParam("streetName") String streetName,
                       @RequestParam("city") String city,
                       @RequestParam("country") String country,
                       @RequestParam("provstate") String provstate,
                       @RequestParam("living") String living,
                       @RequestParam("district") String district,
                       @RequestParam("price") double price,
                       @RequestParam("size") double size,
                       @RequestParam("floors") int floors,
                       @RequestParam("bath") int bath,
                       @RequestParam("bed") int bed,
                       @RequestParam("parking") int parking,
                       @RequestParam("attatched") int attatched,
                       @RequestParam("isNew") String isNew) {

        UUID uuid = UUID.randomUUID();
        MultipleListingService instance = MultipleListingService.getInstance();
        TownHouse property = new TownHouse.Builder(uuid)
                .locatedAt(new Address(streetNum, streetName, provstate, country, city, living, district))
                .pricedAt(price)
                .withSizeInSquareMeters(size)
                .floorsCountedAt(floors)
                .bathroomCountedAt(bath)
                .bedroomCountedAt(bed)
                .parkingSpacesCountedAt(parking)
                .setAsNewConstruct(isNew.equals("yes"))
                .attachedTo(attatched)
                .build();
        instance.addNewProperty(property);

        return createdMessage(property.toString());
    }

    @RequestMapping(value = "/semi", method = RequestMethod.POST)
    public String semi(@RequestParam("streetNum") int streetNum,
                       @RequestParam("streetName") String streetName,
                       @RequestParam("city") String city,
                       @RequestParam("country") String country,
                       @RequestParam("provstate") String provstate,
                       @RequestParam("living") String living,
                       @RequestParam("district") String district,
                       @RequestParam("price") double price,
                       @RequestParam("size") double size,
                       @RequestParam("floors") int floors,
                       @RequestParam("bath") int bath,
                       @RequestParam("bed") int bed,
                       @RequestParam("parking") int parking,
                       @RequestParam("sepPark") String sepPark,
                       @RequestParam("isNew") String isNew) {

        UUID uuid = UUID.randomUUID();
        MultipleListingService instance = MultipleListingService.getInstance();
        SemiDetach property = new SemiDetach.Builder(uuid)
                .locatedAt(new Address(streetNum, streetName, provstate, country, city, living, district))
                .pricedAt(price)
                .withSizeInSquareMeters(size)
                .floorsCountedAt(floors)
                .bathroomCountedAt(bath)
                .bedroomCountedAt(bed)
                .parkingSpacesCountedAt(parking)
                .setHasSeparateParking(sepPark.equals("yes"))
                .setAsNewConstruct(isNew.equals("yes"))
                .build();
        instance.addNewProperty(property);

        return createdMessage(property.toString());
    }

    @RequestMapping(value = "/detach", method = RequestMethod.POST)
    public String detach(@RequestParam("streetNum") int streetNum,
                         @RequestParam("streetName") String streetName,
                         @RequestParam("city") String city,
                         @RequestParam("country") String country,
                         @RequestParam("provstate") String provstate,
                         @RequestParam("living") String living,
                         @RequestParam("district") String district,
                         @RequestParam("price") double price,
                         @RequestParam("size") double size,
                         @RequestParam("floors") int floors,
                         @RequestParam("bath") int bath,
                         @RequestParam("bed") int bed,
                         @RequestParam("parking") int parking,
                         @RequestParam("isNew") String isNew) {

        UUID uuid = UUID.randomUUID();
        MultipleListingService instance = MultipleListingService.getInstance();
        Detach property = new Detach.Builder(uuid)
                .locatedAt(new Address(streetNum, streetName, provstate, country, city, living, district))
                .pricedAt(price)
                .withSizeInSquareMeters(size)
                .floorsCountedAt(floors)
                .bathroomCountedAt(bath)
                .bedroomCountedAt(bed)
                .parkingSpacesCountedAt(parking)
                .setAsNewConstruct(isNew.equals("yes"))
                .build();
        instance.addNewProperty(property);

        return createdMessage(property.toString());
    }

    @RequestMapping(value = "/parking", method = RequestMethod.POST)
    public String parking(@RequestParam("streetNum") int streetNum,
                          @RequestParam("streetName") String streetName,
                          @RequestParam("city") String city,
                          @RequestParam("country") String country,
                          @RequestParam("provstate") String provstate,
                          @RequestParam("size") double size,
                          @RequestParam("parking") int parking,
                          @RequestParam("floors") int floors,
                          @RequestParam("isNew") String isNew,
                          @RequestParam("type") String type) {

        UUID uuid = UUID.randomUUID();
        MultipleListingService instance = MultipleListingService.getInstance();
        String living = "N/A", district = "N/A";
        ParkingLot property = new ParkingLot.Builder(uuid)
                .locatedAt(new Address(streetNum, streetName, provstate, country, city, living, district))
                .withSizeInSquareMeters(size)
                .numParkingSpacesAt(parking)
                .floorsCountedAt(floors)
                .setAsNewConstruct(isNew.equals("yes"))
                .withParkingType(type)
                .build();
        instance.addNewProperty(property);

        return createdMessage(property.toString());
    }

    @RequestMapping(value = "/locker", method = RequestMethod.POST)
    public String locker(@RequestParam("streetNum") int streetNum,
                         @RequestParam("streetName") String streetName,
                         @RequestParam("city") String city,
                         @RequestParam("country") String country,
                         @RequestParam("provstate") String provstate,
                         @RequestParam("size") double size,
                         @RequestParam("price") double price,
                         @RequestParam("floors") int floors,
                         @RequestParam("isNew") String isNew,
                         @RequestParam("isHeated") String isHeated) {

        UUID uuid = UUID.randomUUID();
        MultipleListingService instance = MultipleListingService.getInstance();
        String living = "N/A", district = "N/A";
        LockersAndStorage property = new LockersAndStorage.Builder(uuid)
                .locatedAt(new Address(streetNum, streetName, provstate, country, city, living, district))
                .withSizeInSquareMeters(size)
                .floorsCountedAt(floors)
                .costing(price)
                .setAsNewConstruct(isNew.equals("yes"))
                .setIsHeated(isHeated.equals("yes"))
                .build();
        instance.addNewProperty(property);

        return createdMessage(property.toString());
    }

    @RequestMapping(value = "/search")
    public String search(@RequestParam("uuid") UUID uuid) {
        Land property = Cache.getInstance().searchById(uuid);
        if (property == null) {
            property = MultipleListingService.getInstance().searchById(uuid);
            if (property == null) {
                return "No property with this uuid found. " + goToMessage();
            } else Cache.getInstance().addNewProperty(property);
        }
        return "Property found: " + property.toString() + "    " + goToMessage();
    }

    @RequestMapping(value = "delete")
    public String delete(@RequestParam("uuid") UUID uuid) {
        MultipleListingService.getInstance().removeProperty(uuid);
        Cache.getInstance().removeProperty(uuid);
        return "If the property was saved, it has been removed. " + goToMessage();
    }

    @RequestMapping(value = "/multiplexmod", method = RequestMethod.POST)
    public String multiplexmod(@RequestParam("uuid") UUID uuid,
                            @RequestParam("price") double price,
                            @RequestParam("size") double size,
                            @RequestParam("floors") int floors,
                            @RequestParam("bath") int bath,
                            @RequestParam("bed") int bed,
                            @RequestParam("parking") int parking,
                            @RequestParam("isNew") String isNew) {

        Multiplex property = null;
        Land land = Cache.getInstance().searchById(uuid);
        if (land == null) {
            land = MultipleListingService.getInstance().searchById(uuid);
            if (land == null) {
                return "No property with this uuid found. " + goToMessage();
            }
        }
        if (land instanceof Multiplex) property = (Multiplex) land; // safe casting to access all methods
        if (property != null){
            // remove old
            MultipleListingService.getInstance().removeProperty(uuid);
            Cache.getInstance().removeProperty(uuid);
            property.setPrice(price);
            property.setFloorCount(floors);
            property.setBathroomCount(bath);
            property.setBedroomCount(bed);
            property.setParkingSpacesCount(parking);
            property.setSizeInSquareMeters(size);
            property.setNewConstruction(isNew.equals("yes"));
            // add new
            MultipleListingService.getInstance().addNewProperty(property);
            Cache.getInstance().addNewProperty(property);
            return "Changes Made! " + goToMessage();
        }
        else return "Error has occured. " + goToMessage();
    }

    @RequestMapping(value = "/tripledmod", method = RequestMethod.POST)
    public String tripledmod(@RequestParam("uuid") UUID uuid,
                             @RequestParam("price") double price,
                             @RequestParam("size") double size,
                             @RequestParam("floors") int floors,
                             @RequestParam("bath") int bath,
                             @RequestParam("bed") int bed,
                             @RequestParam("parking") int parking,
                             @RequestParam("isNew") String isNew) {

        TripleDecker property = null;
        Land land = Cache.getInstance().searchById(uuid);
        if (land == null) {
            land = MultipleListingService.getInstance().searchById(uuid);
            if (land == null) {
                return "No property with this uuid found. " + goToMessage();
            }
        }
        if (land instanceof TripleDecker) property = (TripleDecker) land; // safe casting to access all methods
        if (property != null){
            // remove old
            MultipleListingService.getInstance().removeProperty(uuid);
            Cache.getInstance().removeProperty(uuid);
            property.setPrice(price);
            property.setFloorCount(floors);
            property.setBathroomCount(bath);
            property.setBedroomCount(bed);
            property.setParkingSpacesCount(parking);
            property.setSizeInSquareMeters(size);
            property.setNewConstruction(isNew.equals("yes"));
            // add new
            MultipleListingService.getInstance().addNewProperty(property);
            Cache.getInstance().addNewProperty(property);
            return "Changes Made! " + goToMessage();
        }
        else return "Error has occured. " + goToMessage();
    }

    @RequestMapping(value = "/agriculturemod", method = RequestMethod.POST)
    public String agcriculturemod(@RequestParam("uuid") UUID uuid,
                                  @RequestParam("price") double price,
                                  @RequestParam("size") double size) {

        Agriculture property = null;
        Land land = Cache.getInstance().searchById(uuid);
        if (land == null) {
            land = MultipleListingService.getInstance().searchById(uuid);
            if (land == null) {
                return "No property with this uuid found. " + goToMessage();
            }
        }
        if (land instanceof Agriculture) property = (Agriculture) land; // safe casting to access all methods
        if (property != null){
            // remove old
            MultipleListingService.getInstance().removeProperty(uuid);
            Cache.getInstance().removeProperty(uuid);
            property.setPrice(price);
            property.setSizeInSquareMeters(size);
            // add new
            MultipleListingService.getInstance().addNewProperty(property);
            Cache.getInstance().addNewProperty(property);
            return "Changes Made! " + goToMessage();
        }
        else return "Error has occured. " + goToMessage();
    }

    @RequestMapping(value = "/mobilemod", method = RequestMethod.POST)
    public String mobilemod(@RequestParam("uuid") UUID uuid,
                            @RequestParam("price") double price,
                            @RequestParam("size") double size,
                            @RequestParam("floors") int floors,
                            @RequestParam("bath") int bath,
                            @RequestParam("bed") int bed,
                            @RequestParam("isNew") String isNew) {

        Mobile property = null;
        Land land = Cache.getInstance().searchById(uuid);
        if (land == null) {
            land = MultipleListingService.getInstance().searchById(uuid);
            if (land == null) {
                return "No property with this uuid found. " + goToMessage();
            }
        }
        if (land instanceof Mobile) property = (Mobile) land; // safe casting to access all methods
        if (property != null){
            // remove old
            MultipleListingService.getInstance().removeProperty(uuid);
            Cache.getInstance().removeProperty(uuid);
            property.setPrice(price);
            property.setFloorCount(floors);
            property.setBathroomCount(bath);
            property.setBedroomCount(bed);
            property.setNewConstruction(isNew.equals("yes"));
            property.setSizeInSquareMeters(size);
            // add new
            MultipleListingService.getInstance().addNewProperty(property);
            Cache.getInstance().addNewProperty(property);
            return "Changes Made! " + goToMessage();
        }
        else return "Error has occured. " + goToMessage();
    }

    @RequestMapping(value = "/apartmentmod", method = RequestMethod.POST)
    public String apartmentmod(@RequestParam("uuid") UUID uuid,
                               @RequestParam("price") double price,
                               @RequestParam("size") double size,
                               @RequestParam("floors") int floors,
                               @RequestParam("bath") int bath,
                               @RequestParam("bed") int bed,
                               @RequestParam("parking") String parking,
                               @RequestParam("isNew") String isNew) {

        Apartment property = null;
        Land land = Cache.getInstance().searchById(uuid);
        if (land == null) {
            land = MultipleListingService.getInstance().searchById(uuid);
            if (land == null) {
                return "No property with this uuid found. " + goToMessage();
            }
        }
        if (land instanceof Apartment) property = (Apartment) land; // safe casting to access all methods
        if (property != null){
            // remove old
            MultipleListingService.getInstance().removeProperty(uuid);
            Cache.getInstance().removeProperty(uuid);
            property.setPrice(price);
            property.setFloorCount(floors);
            property.setBathroomCount(bath);
            property.setBedroomCount(bed);
            property.setParking(parking.equals("yes"));
            property.setNewConstruct(isNew.equals("yes"));
            property.setSizeInSquareMeters(size);
            // add new
            MultipleListingService.getInstance().addNewProperty(property);
            Cache.getInstance().addNewProperty(property);
            return "Changes Made! " + goToMessage();
        }
        else return "Error has occured. " + goToMessage();
    }

    @RequestMapping(value = "/townmod", method = RequestMethod.POST)
    public String townmod(@RequestParam("uuid") UUID uuid,
                          @RequestParam("price") double price,
                          @RequestParam("size") double size,
                          @RequestParam("floors") int floors,
                          @RequestParam("bath") int bath,
                          @RequestParam("bed") int bed,
                          @RequestParam("parking") int parking,
                          @RequestParam("isNew") String isNew) {

        TownHouse property = null;
        Land land = Cache.getInstance().searchById(uuid);
        if (land == null) {
            land = MultipleListingService.getInstance().searchById(uuid);
            if (land == null) {
                return "No property with this uuid found. " + goToMessage();
            }
        }
        if (land instanceof TownHouse) property = (TownHouse) land; // safe casting to access all methods
        if (property != null){
            // remove old
            MultipleListingService.getInstance().removeProperty(uuid);
            Cache.getInstance().removeProperty(uuid);
            property.setPrice(price);
            property.setFloorCount(floors);
            property.setBathroomCount(bath);
            property.setBedroomCount(bed);
            property.setParkingSpacesCount(parking);
            property.setNewConstruction(isNew.equals("yes"));
            property.setSizeInSquareMeters(size);
            // add new
            MultipleListingService.getInstance().addNewProperty(property);
            Cache.getInstance().addNewProperty(property);
            return "Changes Made! " + goToMessage();
        }
        else return "Error has occured. " + goToMessage();
    }

    @RequestMapping(value = "/semimod", method = RequestMethod.POST)
    public String semimod(@RequestParam("uuid") UUID uuid,
                          @RequestParam("price") double price,
                          @RequestParam("size") double size,
                          @RequestParam("floors") int floors,
                          @RequestParam("bath") int bath,
                          @RequestParam("bed") int bed,
                          @RequestParam("parking") int parking,
                          @RequestParam("isNew") String isNew) {

        SemiDetach property = null;
        Land land = Cache.getInstance().searchById(uuid);
        if (land == null) {
            land = MultipleListingService.getInstance().searchById(uuid);
            if (land == null) {
                return "No property with this uuid found. " + goToMessage();
            }
        }
        if (land instanceof SemiDetach) property = (SemiDetach) land; // safe casting to access all methods
        if (property != null){
            // remove old
            MultipleListingService.getInstance().removeProperty(uuid);
            Cache.getInstance().removeProperty(uuid);
            property.setPrice(price);
            property.setFloorCount(floors);
            property.setBathroomCount(bath);
            property.setBedroomCount(bed);
            property.setParkingSpacesCount(parking);
            property.setNewConstruction(isNew.equals("yes"));
            property.setSizeInSquareMeters(size);
            // add new
            MultipleListingService.getInstance().addNewProperty(property);
            Cache.getInstance().addNewProperty(property);
            return "Changes Made! " + goToMessage();
        }
        else return "Error has occured. " + goToMessage();
    }

    @RequestMapping(value = "/detachmod", method = RequestMethod.POST)
    public String detachmod(@RequestParam("uuid") UUID uuid,
                            @RequestParam("price") double price,
                            @RequestParam("size") double size,
                            @RequestParam("floors") int floors,
                            @RequestParam("bath") int bath,
                            @RequestParam("bed") int bed,
                            @RequestParam("parking") int parking,
                            @RequestParam("isNew") String isNew) {

        Detach property = null;
        Land land = Cache.getInstance().searchById(uuid);
        if (land == null) {
            land = MultipleListingService.getInstance().searchById(uuid);
            if (land == null) {
                return "No property with this uuid found. " + goToMessage();
            }
        }
        if (land instanceof Detach) property = (Detach) land; // safe casting to access all methods
        if (property != null){
            // remove old
            MultipleListingService.getInstance().removeProperty(uuid);
            Cache.getInstance().removeProperty(uuid);
            property.setPrice(price);
            property.setFloorCount(floors);
            property.setBathroomCount(bath);
            property.setBedroomCount(bed);
            property.setParkingSpacesCount(parking);
            property.setNewConstruction(isNew.equals("yes"));
            property.setSizeInSquareMeters(size);
            // add new
            MultipleListingService.getInstance().addNewProperty(property);
            Cache.getInstance().addNewProperty(property);
            return "Changes Made! " + goToMessage();
        }
        else return "Error has occured. " + goToMessage();
    }

    @RequestMapping(value = "/parkingmod", method = RequestMethod.POST)
    public String parkingmod(@RequestParam("uuid") UUID uuid,
                             @RequestParam("size") double size,
                             @RequestParam("floors") int floors,
                             @RequestParam("parking") int parking,
                             @RequestParam("isNew") String isNew) {

        ParkingLot property = null;
        Land land = Cache.getInstance().searchById(uuid);
        if (land == null) {
            land = MultipleListingService.getInstance().searchById(uuid);
            if (land == null) {
                return "No property with this uuid found. " + goToMessage();
            }
        }
        if (land instanceof ParkingLot) property = (ParkingLot) land; // safe casting to access all methods
        if (property != null){
            // remove old
            MultipleListingService.getInstance().removeProperty(uuid);
            Cache.getInstance().removeProperty(uuid);
            property.setNumParkingSpaces(parking);
            property.setFloors(floors);
            property.setSizeInSquareMeters(size);
            property.setNewConstruction(isNew.equals("yes"));
            property.setSizeInSquareMeters(size);
            // add new
            MultipleListingService.getInstance().addNewProperty(property);
            Cache.getInstance().addNewProperty(property);
            return "Changes Made! " + goToMessage();
        }
        else return "Error has occured. " + goToMessage();
    }

    @RequestMapping(value = "/lockermod", method = RequestMethod.POST)
    public String lockermod(@RequestParam("uuid") UUID uuid,
                            @RequestParam("price") double price,
                            @RequestParam("size") double size,
                            @RequestParam("floors") int floors,
                            @RequestParam("isNew") String isNew,
                            @RequestParam("isHeated") String isHeated) {

        LockersAndStorage property = null;
        Land land = Cache.getInstance().searchById(uuid);
        if (land == null) {
            land = MultipleListingService.getInstance().searchById(uuid);
            if (land == null) {
                return "No property with this uuid found. " + goToMessage();
            }
        }
        if (land instanceof LockersAndStorage) property = (LockersAndStorage) land; // safe casting to access all methods
        if (property != null){
            // remove old
            MultipleListingService.getInstance().removeProperty(uuid);
            Cache.getInstance().removeProperty(uuid);
            property.setFloorCount(floors);
            property.setRentalCost(price);
            property.setHeated(isHeated.equals("yes"));
            property.setNewConstruction(isNew.equals("yes"));
            property.setSizeInSquareMeters(size);
            // add new
            MultipleListingService.getInstance().addNewProperty(property);
            Cache.getInstance().addNewProperty(property);
            return "Changes Made! " + goToMessage();
        }
        else return "Error has occured. " + goToMessage();
    }


    private String createdMessage(String s) {
        return "Property made: " + s + "    <---Record uuid for reference     " + goToMessage();
    }

    private String goToMessage() {
        return "Go to: \"http://localhost:8080/\" to go back to main menu";
    }
}
