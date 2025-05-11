

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RoadTest {

	private Town townA;
	private Town townB;
	private Road road1;
	private Road road2;
	
	
	@Before
	public void setUp() throws Exception {
		townA = new Town("TownA");
		townB = new Town("TownB");
		road1 = new Road(townA, townB, 10, "MainStreet");
		road2 = new Road(townB, townA, 10, "MainStreet");
		
	}


	@Test
	public void testConstructor() {
		assertNotNull(road1);
		
	}

	@Test
	public void testGetName() {
		
		assertEquals("MainStreet", road1.getName());
	}

	@Test
	public void testGetWeight() {

		assertEquals(10, road1.getWeight());
	}

	@Test
	public void testGetSource() {

		assertEquals(townA, road1.getSource());
	}
	
	@Test
	public void testGetDestination() {

		assertEquals(townB, road1.getDestination());
	}
	

	@Test
	public void testEquals() {

		assertTrue(road1.equals(road2));
		assertTrue(road2.equals(road1));
	}
	
	@Test
	public void testCompareTo() {

		Road road3 = new Road(townA, townB, 5, "Broadway");
		
		assertTrue(road3.compareTo(road1) < 0);
		assertTrue(road1.compareTo(road3) > 0);
		assertEquals(0, road1.compareTo(road2));
		
	}

	@Test
	public void testContains() {

		Road road3 = new Road(townA, townB, 5, "Broadway");
		
		assertTrue(road1.contains(townA));
		assertTrue(road1.contains(townB));
		assertFalse(road1.contains(new Town("TownC")));
		
	}
	
	@Test
	public void testtoString() {

		String string = road1.toString();
		
		assertTrue(string.contains("MainStreet"));
		assertTrue(string.contains("TownA"));
		assertTrue(string.contains("TownB"));
		assertTrue(string.contains("10"));
		
		
	}

}























