package application;

import java.util.ArrayList;


/*
 * Binary tree structure to help translate morse code into words and letters
 *  The dots (".") represent left traversal and the dashes ("-") represent right traversal
 */
public class MorseCodeTree extends java.lang.Object implements LinkedConverterTreeInterface<java.lang.String> {
	
	private TreeNode<String> root;
	
	/*
	 * Constructs morse code tree and calls buildTree method
	 */
	public MorseCodeTree() {
		root = new TreeNode<>("");
		buildTree(); 
	}
	
	/*
	 * Returns root node of the morse code tree
	 * 
	 * @return root, the toot of treeNode
	 */
	@Override
	public TreeNode<java.lang.String> getRoot(){
		
		return root; 
	}
	
	
	/*
	 * Builds morse code tree with alphabet and their respective morse code translation
	 */
	public void buildTree() {
		
		insert(".", "e");
		insert("-", "t");
		
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n"); 
		insert("--", "m");
		
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g"); 
		insert("---", "o");
		
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert("..--", "null");
		insert(".-..", "l");
		insert(".-.-", "null");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x"); 
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q"); 
		insert("---.", "null");
		insert("----", "null");
	}
	
	/*
	 * Performs an LNR traversal of the tree, stores this value in a list
	 * 
	 * @return list, an ArrayList of the tree's data in LNR sequence
	 */
	public java.util.ArrayList<java.lang.String> toArrayList(){
		
		java.util.ArrayList<java.lang.String> list = new java.util.ArrayList<>();
		LNRoutputTraversal(getRoot(), list); 
		
		return list;
	}

	/*
	 * Sets root of the tree
	 * 
	 * @param newNode, the node to be set as root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) { 
		this.root = newNode;
	}

	/*
	 * Inserts a new letter into the tree using morse code path
	 * 
	 * @param code, the morse code sample
	 * @param letter, the letter corresponding to the morse code sample
	 */
	@Override
	public void insert(String code, String letter) {
		addNode(root, code, letter); 
		 
	}

	/*
	 * Recursively adds node to the correct location in the tree based on morse code
	 * 
	 * @param root, the current node
	 * @param code, the remaining morse code
	 * @param letter, the letter to be inserted
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		char firstCharacter = code.charAt(0);
		String restOfCode = code.substring(1);
		
		if (code.length() == 1){
			if (code.equals(".")) { 
				root.setLeft(new TreeNode<>(letter));
			} 
			
			else if (code.equals("-")){ 
				root.setRight(new TreeNode<>(letter));
			}
			return;
			
		}
		
		if (firstCharacter == '.') {
			if (root.getLeft() == null) {
				root.setLeft(new TreeNode<>(""));
			}
			
			addNode(root.getLeft(), restOfCode, letter);
		}
		
		else if (firstCharacter == '-') {
			if (root.getRight() == null) {
				root.setRight(new TreeNode<>(""));
			}
			
			addNode(root.getRight(), restOfCode, letter);
		}
	}
		
	/*
	 * Fetches letter associated with the provided morse code
	 * 
	 * @param code, morse code string
	 * @return the corresponding letter
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
		
	}
	
	/*
	 * Recursively navigates the tree in order to retrieve the letters
	 * 
	 * @param root, the current node
	 * @param code, the remaining morse code
	 * @param letter, the letter to be inserted
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		
		 if (code == null) {
			 if (root == null) { 
				 return null;
			 } else {
				 return root.getData();
			 }
		 }
		 
		 if (code.equals("")) {
			 if (root == null) { 
				 return null;
			 } else {
				 return root.getData();
			 }
		 }
		 
		 
		char firstCharacter = code.charAt(0);
		String restOfCode = code.substring(1);
		
		if (code.length() == 1){
			if (code.equals(".")) {
				return root.getLeft().getData();
			} 
			
			else if (code.equals("-")){
				return root.getRight().getData();
			}
		}
		
		if (firstCharacter == '.') {
			return fetchNode(root.getLeft(), restOfCode);
		}
		else if (firstCharacter == '-') {
			return fetchNode(root.getRight(), restOfCode);
		}
		
		
		return null;
	}

	/*
	 * Throws UnsupportedOperationException because delete is not supported for MorseCodeTree
	 * 
	 * @param data, the data to be deleted
	 * @throws UnsupportedOperationException every time
	 * @return 
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Operation not supported in the MorseCodeTree"); 
	}
	
	/*
	 * Throws UnsupportedOperationException because update is not supported for MorseCodeTree
	 * 
	 * @throws UnsupportedOperationException every time
	 * @return 
	 */
	public MorseCodeTree update() throws java.lang.UnsupportedOperationException{
		
		throw new UnsupportedOperationException("This operation is not supported in the MorseCodeTree");
	}

	/*
	 * Recursive LNR traversal and stores the result in a list
	 * 
	 * @param root, the current root
	 * @param list, the list where the results will be stored in
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		LNRoutputTraversal(root.getLeft(), list); 
		list.add(root.getData());
		LNRoutputTraversal(root.getRight(), list);
	}



}
