

public class Road extends java.lang.Object implements java.lang.Comparable<Road>{
	
	private Town source;
	private Town destination;
	private int i;
	private String name;
	
	/*
	 * Constructor
	 * 
	 * @param source, One town on the road
	 * @param destination, Another town on the road
	 * @param i, Weight of the edge, i.e., distance from one town to the other
	 * @param roadName, Name of the road
	 */
	public Road(Town source, Town destination, int degrees, java.lang.String name){
		
		this.source = source;
		this.destination = destination;
		this.i = degrees;
		this.name = name;
	}
	
	/*
	 * Constructor with weight preset at 1
	 * 
	 * @param source, One town on the road
	 * @param destination, Another town on the road
	 * @param roadName, Name of the road
	 */
	public Road(Town source,Town destination, java.lang.String name) {
		
		this.source = source;
		this.destination = destination;
		this.i = 1;
		this.name = name;
	}
	
	/*
	 * Returns true only if the edge contains the given town
	 * 
	 * @param town, a vertex of the graph
	 * @return true only if the edge is connected to the given vertex
	 */
	public boolean contains(Town town) {
		
		if (source.equals(town)) {
			return true;
		}
		
		if (destination.equals(town)) {
			return true;
		}
		
		return false;
	}
	
	/*
	 * To string method
	 */
	public java.lang.String toString(){
		
		return name + " connects the cities " + source.getName() + " and "+ destination.getName() 
		+ ", " + name+ " is " + i + " distance away";
	}

	/*
	 * Returns the road name
	 * 
	 * @return The name of the road
	 */
	public java.lang.String getName(){
		
		return name;
	}

	/*
	 * Returns the second town on the road
	 * 
	 * @return A town on the road
	 */
	public Town getDestination() {
		
		return destination;
	}

	/*
	 * Returns the first town on the road
	 * 
	 * @return A town on the road
	 */
	public Town getSource() {
		
		return source;
	}

	/*
	 * @return 0 if the road names are the same, a positive or negative number if the road names 
	 * are not the same
	 */
	@Override
	public int compareTo(Road o) {
		
		return this.name.compareTo(o.name);
	}

	/*
	 * Returns the distance of the road
	 * 
	 * @return the distance of the road
	 */
	public int getWeight() {
		
		
		return i;
	}

	/*
	 * Returns true if each of the ends of the road r is the same as the ends of this road. 
	 * Remember that a road that goes from point A to point B is the same as a road that goes 
	 * from point B to point A.
	 * 
	 * @param r, road object to compare it to
	 */
	public boolean equals(java.lang.Object r) {
		
		
		if (this == r) {
			return true;
		}
		
		if (r == null) {
			return false;
		}
		
		if (r.getClass() != this.getClass()) {
			return false;
		}
		
		Road roadExample = (Road) r;
		
		boolean namesEqual = this.name.equals(roadExample.name);
		boolean weightsEqual = this.i == roadExample.i;
		boolean townsEqual = (this.source.equals(roadExample.source) && this.destination.equals(roadExample.destination)) ||
				(this.source.equals(roadExample.destination) && this.destination.equals(roadExample.source));
		
		
		
		return namesEqual && weightsEqual && townsEqual;
	}
	
}


























