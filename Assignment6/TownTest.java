

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TownTest {
	
	private Town town1;
	private Town town2;     
	private Town townCopy;
	

	@Before
	public void setUp() throws Exception {
		
		town1 = new Town("Montreal");
		town2 = new Town("Toronto");
		townCopy = new Town(town1);
	}

	@Test
	public void testConstructor() {
		
		assertEquals("Montreal",town1.getName());
		assertEquals("Toronto",town2.getName());
	}

	@Test
	public void testCopyConstructor() {
		
		assertEquals(town1.getName(), townCopy.getName());
		assertNotSame(town1, townCopy);
		
	}

	
	
	@Test
	public void testGetName() {
		
		assertEquals("Toronto",town2.getName()); 
	}

	@Test
	public void testEqualsName() {
		
		Town town3 = new Town("Montreal"); 
		assertTrue(town1.equals(town3));
	}

	@Test
	public void testEqualsNull() {

		assertFalse(town1.equals(null)); 
	}

	@Test
	public void testHash() {
		
		Town town4 = new Town("Montreal");
		 
		assertEquals(town1.hashCode(), town4.hashCode()); 
	}

	@Test
	public void testCompareTo() {
		
		
		int r = town1.compareTo(town2); 
		assertNotEquals(0, r);
		
		Town town5 = new Town("Montreal"); 
		assertEquals(0, town1.compareTo(town5));
	}

	@Test
	public void testToString() {
		
		assertEquals("Montreal", town1.toString()); 
	}

}






















