

public class Town extends java.lang.Object implements java.lang.Comparable<Town> {

	private String name;
	
	/*
	 * Constructor
	 */
	public Town(java.lang.String name){
		
		this.name = name;
	}
	
	/*
	 * Copy constructor
	 * @param templateTown an instance of Town
	 */
	public Town(Town templateTown){
		this.name = templateTown.name;
	}
	
	/*
	 * Copy constructor
	 * @param templateTown an instance of Town
	 */
	public java.lang.String getName(){
		
		return name;
	}
	
	/*
	 * Compare to method
	 * @returns 0 if names are equal, a positive or negative number if the names are not equal
	 */
	@Override
	public int compareTo(Town o) {
		
		return this.name.compareTo(o.name); 
	}
	
	/*
	 * To string method
	 * @return the town name
	 */
	public java.lang.String toString(){
		
		return name;
	}
	
	
	/*
	 * hashcode
	 * 
	 * @return the hashcode for the name of the town
	 */
	@Override
	public int hashCode() {
		
		if (name == null) {
			return 0;
		}
		
		return name.hashCode();
	}
	
	
	/*
	 * Compares the town names to see if they are equal to each other
	 * 
	 * @return true if the town names are equal, false if not
	 */
	@Override 
	public boolean equals(java.lang.Object obj) {
		
		if (this == obj) {
			return true; 
		}
		
		if (obj == null) {
			return false;
		}
		
		if (obj.getClass() != this.getClass()) {
			return false; 
		}
		
		Town townExample = (Town) obj;
		
		if(this.name == null) {
			return townExample.name == null;
		}
		else {
			return this.name.equals(townExample.name); 
		}
	} 
	
	
	

}









































