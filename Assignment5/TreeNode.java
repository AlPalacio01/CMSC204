package application;

/*
 * TreeNode class with each node referencing left and right children.
 * 
 * @param <T> Type data that is to be stored in the node
 */
public class TreeNode<T> {
	
	private T data;
	private TreeNode<T> left;
	private TreeNode<T> right;
	

	/*
	 * Constructs a tree node with the data to be stored in the node with the children being null
	 * 
	 * @param dataNode, the data to be stored in the node
	 */
	public TreeNode(T dataNode) {
		
		this.data = dataNode;
		this.left = null;
		this.right = null;
		
	}
	
	
	/*
	 * Creates a deep copy of the tree node as well as its children
	 * 
	 * @param node, the node to be copied
	 */
	public TreeNode(TreeNode<T> node) {
		
		this.data = node.data;
        
		if (node.left != null) {
			this.left = new TreeNode<>(node.left);
        } else {
        	this.left = null;
        }
		
		
		if (node.right != null) {
			this.right = new TreeNode<>(node.right);
		} else {
			this.right = null;
		}
	}
	
	
	/*
	 * Returns the left child of the given node
	 * 
	 * @return left child of the given node
	 */
	public TreeNode<T> getLeft(){
		return left;
	}
	
	/*
	 * Returns the right child of the given node
	 * 
	 * @return right child of the given node
	 */
	public TreeNode<T> getRight(){
		return right;
	}
	
	
	/*
	 * Sets the left child of the given node
	 * 
	 * @param left, the tree node to be set as the left child
	 */
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}
	
	/*
	 * Sets the right child of the given node
	 * 
	 * @param right, the tree node to be set as the right child
	 */
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
	
	/*
	 * Returns the data stored in the node
	 * 
	 * @return the data stored in the node of type T
	 */
	public T getData() {
		return this.data;
	}
}





























