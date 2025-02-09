package zJUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	
	GradeBook gradebook_1;
	GradeBook gradebook_2;

	@BeforeEach
	void setUp() throws Exception {
		gradebook_1 = new GradeBook(5);
		gradebook_2 = new GradeBook(5);
		
		gradebook_1.addScore(8.5);
		gradebook_1.addScore(9.2);
		gradebook_1.addScore(7.9);
		
		gradebook_2.addScore(5.4);
		gradebook_2.addScore(6.8);
		gradebook_2.addScore(9.2);
		gradebook_2.addScore(4.1);
	}

	@AfterEach
	void tearDown() throws Exception {
		
		gradebook_1 = null;
		gradebook_2 = null;
	}


	@Test
	void testAddScore() {
		System.out.println(gradebook_1.toString());
	    System.out.println(gradebook_2.toString());
	    
		assertTrue(gradebook_1.toString().equals("8.5 9.2 7.9 "));
		assertTrue(gradebook_2.toString().equals("5.4 6.8 9.2 4.1 "));
	}

	@Test
	void testSum() {
		assertEquals(25.6, gradebook_1.sum(), 0.0001);
		assertEquals(25.5, gradebook_2.sum(), 0.0001);
	}

	@Test
	void testMinimum() {
		assertEquals(7.9, gradebook_1.minimum(), 0.0001);
		assertEquals(4.1, gradebook_2.minimum(), 0.0001);
	}

	@Test
	void testFinalScore() {
		assertEquals(17.7, gradebook_1.finalScore(), 0.0001);
		assertEquals(21.4, gradebook_2.finalScore(), 0.0001);

	}


}
