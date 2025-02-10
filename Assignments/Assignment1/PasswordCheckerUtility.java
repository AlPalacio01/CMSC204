package application;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class PasswordCheckerUtility extends java.lang.Object {
	
	
	
	public static void comparePasswords​(java.lang.String password, java.lang.String passwordConfirm) throws UnmatchedException{
		
		if (!password.equals(passwordConfirm)) {
			throw new UnmatchedException();
		}
	}
	
	public static boolean comparePasswordsWithReturn​(java.lang.String password, java.lang.String passwordConfirm) {
		
		return password.equals(passwordConfirm);
	}
	
	public static boolean isValidLength​(java.lang.String password) throws LengthException{
		
		if (password.length() >= 6) {
			return true;
		}
		else {
			throw new LengthException();
		}
	}
	
	public static boolean hasUpperAlpha​(java.lang.String password) throws NoUpperAlphaException{
		
		Pattern pattern = Pattern.compile(".*[A-Z].*");
		Matcher matcher = pattern.matcher(password);
		
		if (!matcher.matches()) {
			throw new NoUpperAlphaException();
		}
		else {
			return true;
		}
	}
	
	public static boolean hasLowerAlpha​(java.lang.String password) throws NoLowerAlphaException{
		
		Pattern pattern = Pattern.compile(".*[a-z].*");
		Matcher matcher = pattern.matcher(password);
		
		if (!matcher.matches()) {
			throw new NoLowerAlphaException();
		}
		else {
			return true;
		}
	}
	
	public static boolean hasDigit​(java.lang.String password) throws NoDigitException{
		
		Pattern pattern = Pattern.compile(".*[0-9].*");
		Matcher matcher = pattern.matcher(password);
		
		if (!matcher.matches()) {
			throw new NoDigitException();
		}
		else {
			return true;
		}
	}
	
	public static boolean hasSpecialChar​(java.lang.String password) throws NoSpecialCharacterException{
		
		Pattern pattern = Pattern.compile(".*[^a-zA-Z0-9].*");
		Matcher matcher = pattern.matcher(password);
		
		if (!matcher.matches()) {
			throw new NoSpecialCharacterException();
		}
		else {
			return true;
		}

	}
	
	public static boolean NoSameCharInSequence​(java.lang.String password) throws InvalidSequenceException {

	    for (int i = 0; i < password.length() -2; i++) {

	        if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) == password.charAt(i +2)) {

	            throw new InvalidSequenceException();
	        }
	    }
	    return true;
	}
	
	
	public static boolean isValidPassword​(java.lang.String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		
		if (!isValidLength​(password)) {
			throw new LengthException();
		}
		
		if (!hasUpperAlpha​(password)) {
			throw new NoUpperAlphaException();
		}
		
		if (!hasLowerAlpha​(password)) {
			throw new NoLowerAlphaException();
		}
		
		if (!hasDigit​(password)) {
			throw new NoDigitException();
		}
		
		if (!hasSpecialChar​(password)) {
			throw new NoSpecialCharacterException();
		}
		
		if (!NoSameCharInSequence​(password)) {
			throw new InvalidSequenceException();
		}
		
		return true;
	}
	
	public static boolean hasBetweenSixAndNineChars​(java.lang.String password) {
		
		if (password.length() < 6 || password.length() > 9) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static boolean isWeakPassword​(java.lang.String password) throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
	    if (isValidPassword​(password) && hasBetweenSixAndNineChars​(password)) {
	        throw new WeakPasswordException();
	    }
	    return true;
	}
	
	
	public static ArrayList<String> getInvalidPasswords​(ArrayList<String> passwords) {
		ArrayList<String> invalid = new ArrayList<>(); 

	    for (String password : passwords) {
	    	try {
	    		if (!isValidLength​(password)) {
	    			throw new LengthException(); 
	    		}
	    		if (!hasUpperAlpha​(password)) {
	    			throw new NoUpperAlphaException();
	    		}
	    		if (!hasLowerAlpha​(password)) {
	    			throw new NoLowerAlphaException(); 
	    		}
	    		if (!hasDigit​(password)) {
	    			throw new NoDigitException(); 
	    		}
	    		if (!hasSpecialChar​(password)) {
	    			throw new NoSpecialCharacterException(); 
	    		}
	    		if (!NoSameCharInSequence​(password)) {
	    			throw new InvalidSequenceException(); 
	    		}
	    	} catch(LengthException e) {
	    		invalid.add(password + " The password must be at least 6 characters long"); 
	    	} catch (NoUpperAlphaException e) {
	    		invalid.add(password + " The password must contain at least one uppercase alphabetic character"); 
	    	} catch (NoLowerAlphaException e) {
	        	invalid.add(password + " The password must contain at least one lowercase alphabetic character");
	    	} catch (NoDigitException e) {
	    		invalid.add(password + " The password must contain at least one digit"); 
	    	} catch (NoSpecialCharacterException e) {
	        	invalid.add(password + " The password must contain at least one special character");
	    	} catch (InvalidSequenceException e) {
	        	invalid.add(password + " The password cannot contain more than two of the same character in sequence"); 
	    	}
	    }
	    return invalid;
	}
}

