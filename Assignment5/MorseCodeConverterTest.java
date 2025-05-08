package application;

import static org.junit.Assert.*;

import java.io.File;
import org.junit.Test;

public class MorseCodeConverterTest {

	

	@Test
	public void testConvertToEnglishString() {
		 String morseCodeExample = ".-.. --- ...- . / .-.. --- --- -.- ... / -. --- - / .-- .. - .... / - .... . / . -.-- . ... / -... ..- - / .-- .. - .... / - .... . / -- .. -. -..";
		 String expectedResult = "love looks not with the eyes but with the mind";
		 String actualResult = MorseCodeConverter.convertToEnglish(morseCodeExample);
		 
		 assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testConvertToEnglishFile() throws Exception{
		
		File fileExample = new File("Daisy.txt"); 
		String expectedResult = "give me your answer do";
		String actualResult = MorseCodeConverter.convertToEnglish(fileExample ); 
		
		assertEquals(expectedResult, actualResult);
	}

}
