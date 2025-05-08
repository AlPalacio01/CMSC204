package application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MorseCodeTreeTest {

	private MorseCodeTree treeExample;

	@Before
	public void setUp() throws Exception {
		treeExample = new MorseCodeTree();
	}

	@Test
	public void testFetchChar() {
		
		assertEquals("e", treeExample.fetch("."));
		assertEquals("t", treeExample.fetch("-"));
		
		assertEquals("i", treeExample.fetch(".."));
		assertEquals("a", treeExample.fetch(".-"));
		assertEquals("n", treeExample.fetch("-."));
		assertEquals("m", treeExample.fetch("--"));
		
		assertEquals("s", treeExample.fetch("..."));
		assertEquals("u", treeExample.fetch("..-"));
		assertEquals("r", treeExample.fetch(".-."));
		assertEquals("w", treeExample.fetch(".--"));
		assertEquals("d", treeExample.fetch("-.."));
		assertEquals("k", treeExample.fetch("-.-"));
		assertEquals("g", treeExample.fetch("--."));
		assertEquals("o", treeExample.fetch("---"));
		
		assertEquals("h", treeExample.fetch("...."));
		assertEquals("v", treeExample.fetch("...-"));
		assertEquals("f", treeExample.fetch("..-."));
		assertEquals("l", treeExample.fetch(".-.."));
		assertEquals("p", treeExample.fetch(".--."));
		assertEquals("j", treeExample.fetch(".---"));
		assertEquals("b", treeExample.fetch("-..."));
		assertEquals("x", treeExample.fetch("-..-"));
		assertEquals("c", treeExample.fetch("-.-."));
		assertEquals("y", treeExample.fetch("-.--"));
		assertEquals("z", treeExample.fetch("--.."));
		assertEquals("q", treeExample.fetch("--.-"));

		
	}
	
	@Test
	public void testFetchEmptyNode() {
		
	
		String expectedResult = treeExample.getRoot().getData();
		String actualResult = treeExample.fetchNode(treeExample.getRoot(), "");
		
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testInvalidMorse() {
		
		assertEquals("null", treeExample.fetch("---."));
		assertEquals("null", treeExample.fetch("----"));
	}
	
	@Test
	public void testUpdateThrowsException() {
		
		try {
			treeExample.update();
		} catch (UnsupportedOperationException e)  {
			
		}
	
	}
	
	@Test
	public void testDeleteThrowsException() {
		
		try {
			treeExample.delete("a");
		} catch (UnsupportedOperationException e)  {
			
		}
	
	}
	
	
	@Test
	public void testSetGetRoot() {
		TreeNode<String> rootExample = new TreeNode<>("root");
		treeExample.setRoot(rootExample);
		
		assertEquals("root", treeExample.getRoot().getData());
	}

}
