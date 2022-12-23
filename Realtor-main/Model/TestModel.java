package Model;

import static org.junit.Assert.*;
import Utilities.Address;

import java.util.UUID;

import org.junit.Test;

public class TestModel {
@Test
public void testTripleDecker() {
	TripleDecker t= new TripleDecker(UUID.randomUUID());
	Address a= new Address(1,"The pond road","Ontario","Canada","ye","toronto school district");

	 t.setAddress(a);
     t.setPrice(40000);
     t.setBathroomCount(4);
     t.setBedroomCount(5);
     t.setParkingSpacesCount(3);
     t.setFamilyCapacity(4);
     t.setSizeInSquareMeters(3000);
     t.setNewConstruction(false);
	assertEquals(4,t.getFamilyCapacity());
	assertEquals(3,t.getFloorCount());
	assertFalse(""==t.toString());
	assertEquals(t.toString(),"TripleDecker{" +"uuid=" + t.getUuid() +
		    ", address= \"" + a.getAddress() + "\"" +
		    ", sizeInSquareMeters=" + t.getSizeInSquareMeters()+
		    ", bathroomCount=" + t.getBathroomCount() +
		    ", bedroomCount=" + t.getBedroomCount() +
		    ", floorCount=" + t.getFloorCount() +
		    ", parkingSpaceCount=" + t.getParkingSpacesCount() +
		    ", isNewConstruction=" + t.isNewConstruction() +
		    ", price=$" + t.getPrice()+
                ", familyCapacity=" + t.getFamilyCapacity() +
                "}");
	
}

@Test
public void testDetach() {
	Detach d= new Detach(UUID.randomUUID(), 3);
	UUID a = d.getUuid();
	Address b= new Address(1,"The pond road","Ontario","Canada","ye","toronto school district");

	d.setAddress(b);
    d.setPrice(30000);
    d.setBathroomCount(5);
    d.setBedroomCount(4);
    d.setParkingSpacesCount(1);
    d.setSizeInSquareMeters(3000);
    d.setNewConstruction(true);
    
	assertEquals(3,d.getFloorCount());
	assertEquals(1,d.getFamilyCapacity());
	assertEquals(a,d.getUuid());
	
assertEquals(d.toString(),	"Detach{"+ "uuid=" + d.getUuid() +
    ", address= \"" + b.getAddress() + "\"" +
    ", sizeInSquareMeters=" + d.getSizeInSquareMeters()+
    ", bathroomCount=" + d.getBathroomCount() +
    ", bedroomCount=" + d.getBedroomCount() +
    ", floorCount=" + d.getFloorCount() +
    ", parkingSpaceCount=" + d.getParkingSpacesCount() +
    ", isNewConstruction=" + d.isNewConstruction() +
    ", price=$" + d.getPrice()+"}");
	
}

@Test
public void testTownHouse() {
	TownHouse to= new TownHouse(UUID.randomUUID(),2);
	Address a= new Address(1,"The pond road","Ontario","Canada","ye","toronto school district");
	to.setAddress(a);
	to.setPrice(3400);
    to.setBathroomCount(4);
    to.setBedroomCount(5);
    to.setParkingSpacesCount(1);
    to.setSizeInSquareMeters(2000);
    to.setNewConstruction(true);

	
	assertEquals(2,to.getFloorCount());
	assertEquals(1,to.getFamilyCapacity());
	assertEquals(to.toString(),	"TownHouse{"+ "uuid=" + to.getUuid() +
		    ", address= \"" + a.getAddress() + "\"" +
		    ", sizeInSquareMeters=" + to.getSizeInSquareMeters()+
		    ", bathroomCount=" + to.getBathroomCount() +
		    ", bedroomCount=" + to.getBedroomCount() +
		    ", floorCount=" + to.getFloorCount() +
		    ", parkingSpaceCount=" + to.getParkingSpacesCount() +
		    ", isNewConstruction=" + to.isNewConstruction() +
		    ", price=$" + to.getPrice()+
            "attached to " + to.getattached()+
            " houses}");
	
}

@Test
public void testSemiDetach() {
	SemiDetach sd= new SemiDetach(UUID.randomUUID(),2);
	Address a= new Address(1,"The pond road","Ontario","Canada","ye","toronto school district");

	 sd.setAddress(a);
     sd.setPrice(40000);
     sd.setBathroomCount(3);
     sd.setBedroomCount(5);
     sd.setParkingSpacesCount(2);
     sd.setSizeInSquareMeters(2000);
     sd.setNewConstruction(false);
	
	assertEquals(2,sd.getFloorCount());
	assertEquals(1,sd.getFamilyCapacity());
	assertEquals(sd.toString(),	"SemiDetach{"+ "uuid=" + sd.getUuid() +
		    ", address= \"" + a.getAddress() + "\"" +
		    ", sizeInSquareMeters=" + sd.getSizeInSquareMeters()+
		    ", bathroomCount=" + sd.getBathroomCount() +
		    ", bedroomCount=" + sd.getBedroomCount() +
		    ", floorCount=" + sd.getFloorCount() +
		    ", parkingSpaceCount=" + sd.getParkingSpacesCount() +
		    ", isNewConstruction=" + sd.isNewConstruction() +
		    ", price=$" + sd.getPrice()+
            "attached to " + sd.getattached()+
            " house}");
}

@Test
public void testParkingLot() {
	 ParkingLot pl = new ParkingLot(UUID.randomUUID());
	 Address a= new Address(1,"The pond road","Ontario","Canada","ye","toronto school district");

     pl.setAddress(a);
     pl.setParkingType("underground");
     pl.setSizeInSquareMeters(400);
     pl.setNumParkingSpaces(20);
     
     assertEquals(pl.toString(),"ParkingLot{"  + "uuid=" + pl.getUuid() +
             ", address= \"" + a.getAddress() + "\"" +
             ", sizeInSquareMeters=" + pl.getSizeInSquareMeters()+
             ", parkingType=" + pl.getParkingType() +
             ", numParkingSpaces=" + pl.getNumParkingSpaces() +
             "}");
     assertFalse(""==pl.toString());
     assertEquals("underground",pl.getParkingType());
     assertEquals(400,pl.getSizeInSquareMeters(),0.0);
}


@Test
public void Multiplex() {
	Multiplex m = new Multiplex(UUID.randomUUID());
	Address a= new Address(1,"The pond road","Ontario","Canada","ye","toronto school district");

    m.setAddress(a);
    m.setPrice(400);
    m.setFloorCount(4);
    m.setBathroomCount(3);
    m.setBedroomCount(4);
    m.setParkingSpacesCount(4);
    m.setPlexCount(5);
    m.setFamilyCapacity(3);
    m.setSizeInSquareMeters(2500);
    m.setNewConstruction(true);
    assertFalse(""==m.toString());
    assertEquals(m.toString(),m.getPlexCount() + "plex{" +"uuid=" + m.getUuid() +
		    ", address= \"" + a.getAddress() + "\"" +
		    ", sizeInSquareMeters=" + m.getSizeInSquareMeters()+
		    ", bathroomCount=" + m.getBathroomCount() +
		    ", bedroomCount=" + m.getBedroomCount() +
		    ", floorCount=" + m.getFloorCount() +
		    ", parkingSpaceCount=" + m.getParkingSpacesCount() +
		    ", isNewConstruction=" + m.isNewConstruction() +
		    ", price=$" + m.getPrice()+
            ", familyCapacity=" + m.getFamilyCapacity() +
            "}");
    assertEquals(5,m.getPlexCount());
    assertEquals(2500,m.getSizeInSquareMeters(),0.0);
    assertEquals(4,m.getParkingSpacesCount());

}

@Test
public void LockersandStorage() {

	LockersAndStorage las = new LockersAndStorage(UUID.randomUUID());
	Address a= new Address(1,"The pond road","Ontario","Canada","ye","toronto school district");
	las.setRentalCost(35);
	las.setSizeInSquareMeters(200);
	las.setHeated(false);
	las.setFloorCount(3);
	las.setAddress(a);
    las.setNewConstruction(false);
    
    assertFalse(""==las.toString());
    assertEquals(las.toString(),"LockersAndStorage{" + "uuid=" + las.getUuid() +
            ", address= \"" + a.getAddress() + "\"" +
            ", sizeInSquareMeters=" + las.getSizeInSquareMeters()+
            ", floorCount=" + las.getFloorCount() +
    	    ", isHeated=" + las.isHeated() +
    	    ", rentalCost=" + las.getRentalCost() +
    	    "}" );
    assertEquals(false,las.isHeated());
    assertTrue(3==las.getFloorCount());
    assertFalse(las.isNewConstruction()==true);
    
}

@Test
public void Address() {
	Address a= new Address(1,"The pond road","Ontario","Canada","ye","toronto school district");
	assertEquals(a.getAddress(),"1 "+"The pond road, Ontario, Canada");
	
	
}

}
