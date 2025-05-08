package application;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * utility class to convert morse code to words
 * 
 */
public class MorseCodeConverter {
	
	/*
	 * prints the contents of the morse code tree in LNR traversal
	 * 
	 * @return a string of all characters in the morse code tree in LNR traversal separated by spaces
	 */
	public static String printTree(){
		
		MorseCodeTree tree = new MorseCodeTree();
		ArrayList<String> list = tree.toArrayList();
		
		StringBuilder treeData = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			
			treeData.append(list.get(i));
			if (i < list.size() - 1) {
				treeData.append(" ");
			}
		}
		
		return treeData.toString();
	}
	
	
	/*
	 * Converts morse code into english texrt
	 * 
	 * @param code, the code string to be converted
	 * @return translated text
	 */
	public static java.lang.String convertToEnglish(java.lang.String code){
	
		
		MorseCodeTree tree = new MorseCodeTree();
		StringBuilder convert2English = new StringBuilder();
		
		String[] words = code.split(" / ");
		
		for (String word :words) {
			
			String[] letters = word.split(" ");
			
			for (String letter :letters) {
				convert2English.append(tree.fetch(letter));
			}
			convert2English.append(" ");
		}
	
	
		return convert2English.toString().trim();
		
	}
	
	/*
	 * Converts morse code from a fileinto english texrt
	 * 
	 * @param codeFile, the file object that has the morse code to be converted
	 * @return translated text
	 * @throws java.io.FileNotFoundException if the file cannot be found
	 */
	public static java.lang.String convertToEnglish(java.io.File codeFile) throws java.io.FileNotFoundException{
		
		MorseCodeTree tree = new MorseCodeTree();
		Scanner scanner = new Scanner(codeFile);
		StringBuilder convert2English = new StringBuilder();
		
		while (scanner.hasNextLine()) {
			
			String line = scanner.nextLine().trim();
			
			String[] words = line.split(" / ");
			
			for (String word :words) {
				
				String[] letters = word.split(" ");
				
				for (String letter :letters) {
					convert2English.append(tree.fetch(letter));
				}
				convert2English.append(" ");
			}
		}
		
		scanner.close();
		
		return convert2English.toString().trim();
	}

}
































