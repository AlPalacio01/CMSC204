package application;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordCheckerUtilityTest {

	ArrayList<String> passwords;

    @BeforeEach
    public void setUp() throws Exception {
        String[] p = {
            "Hi1!", "Hello1234!", "hello1!", "Hello!", "Hello12345", "Helllo1!!!", 
            "Hello1!", "Hello12345!", "HELLO!1", "Heello123"}; 
        passwords = new ArrayList<String>();
        passwords.addAll(Arrays.asList(p));
    }

	@After
	public void tearDown() throws Exception {
		
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 * @throws LengthException 
	 */
	@Test
	public void testIsValidPasswordTooShortPass() throws LengthException
	{
		PasswordCheckerUtility.isValidLength​(passwords.get(1));
	}
	
	@Test
	public void testIsValidPasswordTooShortFail() throws LengthException
	{
		PasswordCheckerUtility.isValidLength​(passwords.get(0)); 
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 * @throws NoUpperAlphaException 
	 */
	@Test
	public void testIsValidPasswordNoUpperAlphaPass() throws NoUpperAlphaException
	{
		PasswordCheckerUtility.hasUpperAlpha​(passwords.get(1)); 
	}
	
	@Test
	public void testIsValidPasswordNoUpperAlphaFail() throws NoUpperAlphaException
	{
		PasswordCheckerUtility.hasUpperAlpha​(passwords.get(2)); 
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 * @throws NoLowerAlphaException 
	 */
	@Test
	public void testIsValidPasswordNoLowerAlphaPass() throws NoLowerAlphaException
	{
		PasswordCheckerUtility.hasLowerAlpha​(passwords.get(1)); 
	}
	
	@Test
	public void testIsValidPasswordNoLowerAlphaFail() throws NoLowerAlphaException
	{
		PasswordCheckerUtility.hasLowerAlpha​(passwords.get(8));
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 * @throws WeakPasswordException
	 * @throws InvalidSequenceException 
	 * @throws NoSpecialCharacterException 
	 * @throws NoDigitException 
	 * @throws NoLowerAlphaException 
	 * @throws NoUpperAlphaException 
	 * @throws LengthException 
	 */
	
	@Test
	public void testIsWeakPasswordPass() throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		PasswordCheckerUtility.isWeakPassword​(passwords.get(1));
	}
	
	@Test
	public void testIsWeakPasswordFail() throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		PasswordCheckerUtility.isWeakPassword​(passwords.get(0)); 
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 * @throws InvalidSequenceException 
	 */
	@Test
	public void testIsValidPasswordInvalidSequencePass() throws InvalidSequenceException
	{
		PasswordCheckerUtility.NoSameCharInSequence​(passwords.get(1));
	}
	
	@Test
	public void testIsValidPasswordInvalidSequenceFail() throws InvalidSequenceException
	{
		PasswordCheckerUtility.NoSameCharInSequence​(passwords.get(5)); 
	}
	
	/**
	 * Test if the password has at least one digithasDigit​
	 * One test should throw a NoDigitException
	 * @throws NoDigitException 
	 */
	@Test
	public void testIsValidPasswordNoDigitPass() throws NoDigitException
	{
		PasswordCheckerUtility.hasDigit​(passwords.get(1));

	}
	
	@Test
	public void testIsValidPasswordNoDigitFail() throws NoDigitException
	{
		PasswordCheckerUtility.hasDigit​(passwords.get(3)); 
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 * @throws InvalidSequenceException 
	 * @throws NoSpecialCharacterException 
	 * @throws NoDigitException 
	 * @throws NoLowerAlphaException 
	 * @throws NoUpperAlphaException 
	 * @throws LengthException 
	 */
	@Test
	public void testIsValidPasswordSuccessfulPass() throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		PasswordCheckerUtility.isValidPassword​(passwords.get(1));
	}
	
	@Test
	public void testIsValidPasswordSuccessfulFail() throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		PasswordCheckerUtility.isValidPassword​(passwords.get(0));
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> passwords = new ArrayList<>(Arrays.asList("Hi1!", "Hello1234!", "hello1!", 
	    		"Hello!", "Hello12345", "Helllo1!!!", "Hello12345!", "HELLO!1", "Heello123"));
	    ArrayList<String> invalid = PasswordCheckerUtility.getInvalidPasswords​(passwords); 
	    
	    assertTrue(invalid.contains("Hi1! The password must be at least 6 characters long"));
	    assertTrue(invalid.contains("hello1! The password must contain at least one uppercase alphabetic character")); 
	    assertTrue(invalid.contains("Hello! The password must contain at least one digit")); 
	    assertTrue(invalid.contains("Hello12345 The password must contain at least one special character")); 
	    assertTrue(invalid.contains("Helllo1!!! The password cannot contain more than two of the same character in sequence")); 
	    assertTrue(invalid.contains("HELLO!1 The password must contain at least one lowercase alphabetic character")); 
	    
	}

}
