//This class represents a Mobile Property, which is A house.
//Imports:
//Each type of property has a UUID
import java.util.UUID;

public class Mobile extends House{
	
	//Attributes
	public int floorCount, bedroomCount, parkingSpaceCount, price;
	public boolean isNewConstruction;
	
	/**
     * this constructor for Mobile Homes sets the uuid and the floor count.
     *
     * @param the parameter is a uuid
     */
	public Mobile(UUID uuid){
		
		this.setFloorCount(1);//Mobile homes are typically 1 floor.
		this.setBedroomCount(2);//2 bedrooms
		this.setParkingSpacesCount(1);// 1 parking space
		this.setPrice(100000);// $100,000 is the price
		this.setUuid(uuid);
		
		//This Property is not a new construction.
		this.isNewConstruction = false;
		
	}
	
	/**
     * this method returns the bathroom count of the property.
     * @return the bathroom count.
     */
	@Override
	public int getBathroomCount() {
		return this.floorCount;
	}

	/**
     * setBathroomCount is responsible for setting the number of bathrooms in the property,
     * which, due to the fact that it is a residential property, must contain at least 1
     * bathroom.
     *
     * @param the parameter is the specified number of bathrooms which must be > 0.
     */
	@Override
	public void setBathroomCount(int bathroomCount) {
    	//Bathrooms must be at least 1:
		
			if(bathroomCount <= 0) {//throw new Exception("A Mobile Home must have at least 1 bathroom");
				
				System.out.println("A Mobile Home must have at least 1 bathroom");
			
			}else if (bathroomCount > 0 ){
			
				super.setBathroomCount(bathroomCount);
			}	
	}

	/**
     * this method returns the bedroom count of the property.
     * @return the bedroom count.
     */
	@Override
	public int getBedroomCount() {
		return this.bedroomCount;
    }

	/**
     * setBedroomCount is responsible for setting the number of bedrooms in the property,
     * which, due to the fact that it is a residential property, must contain at least 1
     * bedroom.
     *
     * @param the parameter is the specified number of bathrooms which must be > 0.
     */
	@Override
	public void setBedroomCount(int bedroomCount) {
		if(bedroomCount <= 0) {//throw new Exception("A Mobile Home must have at least 1 bedroom");
			
			System.out.println("A Mobile Home must have at least 1 bedroom");
		
		}else if (bedroomCount > 0 ){
		
			super.setBedroomCount(bedroomCount);
		}
    }

	/**
     * this method returns the floor count of the property.
     * @return the floor count.
     */
	@Override
	public int getFloorCount() {
    	return this.floorCount;
    }

	/**
     * setFloorCount is responsible for setting the number of floors in the property,
     * which, due to the fact that it is a residential property, must contain at least 1
     * floor, with a maximum of 2 floors due to the home's mobile state.
     *
     * @param the parameter is the specified number of floor which must be > 0  with a max of 2 floors.
     */
	@Override
	public void setFloorCount(int floorCount) {
		if(floorCount <= 0 || floorCount >= 3) {
			
			System.out.println("Error: A Mobile Home typically has 1 or 2 floors.");
		
		}else if (floorCount == 1 || floorCount == 2){
		
			super.setFloorCount(floorCount);
		}
    }

	/**
     * this method returns the number parking spaces of the property.
     * @return the number of parking spaces at the property.
     */
	@Override
	public int getParkingSpaceCount() {
    	return this.parkingSpaceCount;
    }
	
	/**
     * setParkingSpacesCount is responsible for setting the number of parking spaces at the property,
     * which, due to the fact that it is a Mobile Home, it must contain 1
     * parking space.
     *
     * @param the parameter is the specified number of parking spaces which must be > 0 and equal to 1.
     */
	
	@Override
	public void setParkingSpaceCount(int parkingSpaceCount) {
		if(parkingSpaceCount <= 0 || parkingSpaceCount > 1) {
			
			System.out.println("Error: A Mobile Home typically has 1 parking space.");
		
		}else if (parkingSpaceCount == 1){
		
			super.setParkingSpacesCount(parkingSpaceCount);
		}
    }

	/**
     * this method returns the price of the property.
     * @return the price of the property.
     */
	@Override
	public double getPrice() {
    	return this.price;
    }

	/**
     * setPrice is responsible for setting the price of the property,
     *
     * @param the parameter is the specified price of the property, which is greater than 0.
     */
	@Override
	public void setPrice(double price) {
		if(price <= 0) {
			
			System.out.println("Error: A Mobile Home has a price greater than 0.");
		
		}else if (price > 0){
		
			super.setPrice(price);
		}
    }
	
	/**
	 * The toString() method creates some sort of output for the class.
     * @return a string output of the description of the classes.
     */
	@Override
	public String toString() {
		return "Mobile Home{" +
                super.toString() + //Gets the super classes to String method to run.
                '}';
	}

}


//A Builder Class. This class allows for this class to be instantiated
class Builder{
	
	//First, get the Attributes.
	private Address address;
	private UUID uuid;
	private boolean isNewConstruction;
	private double price, sizeInSquareMeters;
	private int bathroomCount, bedroomCount, parkingSpaceCount, familyCapacity;
	
	/**
	 * The constructor for this builder class sets the UUID.
     */
	public Builder(UUID uuid) {
		this.uuid = uuid;
	}
	
	//A Series of Constructors that are crucial to the building process
	
	/**
	 * The builder class will also be responsible to tell the location of the property.
	 * @param the address of the property.
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
	 * @param the double price of the property.
	 * @return the builder class.
     */
	public Builder pricedAt(double price) {	
		//pass the price holder to this:
		this.price = price;
		return this;
	}
	
	/**
	 * The builder class will also be responsible to tell the number of bedrooms in the property.
	 * @param the integer number of bedrooms in the property.
	 * @return the builder class.
     */
	public Builder bedroomCountedAt(int bedroomCount) {
		this.bedroomCount = bedroomCount;
		return this;
	}
	
	/**
	 * The builder class will also be responsible to tell the number of bathrooms in the property.
	 * @param the integer number of bathrooms in the property.
	 * @return the builder class.
     */
	public Builder bathroomCountedAt(int bathroomCount) {
		this.bathroomCount = bathroomCount;
		return this;
	}
	
	/**
	 * The builder class will also be responsible to tell the number of parking spaces at the property.
	 * @param the integer number of parking spaces at the property.
	 * @return the builder class.
     */
	public Builder parkingSpaceCountedAt(int parkingSpaceCount) {
		this.parkingSpaceCount = parkingSpaceCount;
		return this;
	}
	
	
	/**
	 * The builder class will also be responsible to tell if the property is newly constructed.
	 * @param the boolean that tells if the property is a new construction.
	 * @return the builder class.
     */
	public Builder setAsNewConstruct(boolean isNewConstruction) {
		this.isNewConstruction = isNewConstruction;
		return this;
	}
	
	/**
	 * The builder class will also be responsible to tell the size of the property.
	 * @param the double size of the property.
	 * @return the builder class.
     */
	public Builder withSizeInSquareMeters(double size) {
		this.sizeInSquareMeters = size;
		return this;
	}
	
	/**
	 * Finally, create an object of the Mobile property class. 
	 * This is done after setting all attributes.
	 * @return a finalized object of the Mobile homes class.
     */
	public Mobile build() {
		Mobile mobile = new Mobile(this.uuid);
		
		mobile.setBathroomCount(this.bathroomCount);
		mobile.setBedroomCount(this.bedroomCount);
		mobile.setAddress(this.address);
		mobile.setPrice(this.price);
		mobile.setSizeInSquareMeters(this.sizeInSquareMeters);
		mobile.setNewConstruction(this.isNewConstruction);
		mobile.setParkingSpacesCount(this.parkingSpaceCount);
		
		
		//return a new mobile home:
		return mobile;
	}
	
	
	
}
