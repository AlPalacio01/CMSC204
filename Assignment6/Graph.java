

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;


public class Graph implements GraphInterface<Town, Road> {
	
	private Map<Town, Town> predecessors = new HashMap<>();
	private Map<Town, Integer> distances = new HashMap<>();
	private Set<Town> towns;
	private Set<Road> roads;
	
	public Graph() {
		towns = new HashSet<>();
		roads = new HashSet<>();
	}
	
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		
		Iterator<Road> iterator = roads.iterator();
		
		while (iterator.hasNext()) {
			
			Road road = iterator.next();
			
			boolean containsSource = road.contains(sourceVertex);
			boolean containsDestination = road.contains(destinationVertex);
			
			if (containsSource == true && containsDestination == true) {
				
				return road;
			}
		}
		
		
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		
		if (!towns.contains(sourceVertex)) {
			
			addVertex(sourceVertex);
		}
		
		if (!towns.contains(destinationVertex)) {
			
			addVertex(destinationVertex);
		}
		
		Road newRoad = new Road(sourceVertex, destinationVertex, weight, description);
		boolean successful = roads.add(newRoad);
		
		if (successful == true) {
			return newRoad;
		}
		else {
			return null;
		}
		
	}

	@Override
	public boolean addVertex(Town v) {
		
		return towns.add(v);
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		
		Iterator<Road> iterator = roads.iterator();
		
		while (iterator.hasNext()) { 
			
			Road road = iterator.next();
			
			boolean containsSource = road.contains(sourceVertex);
			boolean containsDestination = road.contains(destinationVertex);
			
			if (containsSource == true && containsDestination == true) {
				
				return true;
			}
		}
		
		
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
		
		return towns.contains(v); 
	}

	@Override
	public Set<Road> edgeSet() {
		
		return roads;
	}
	
	@Override
	public Set<Town> vertexSet() { 

		return towns;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		
		Set<Road> edges = new HashSet<>();
		
		Iterator<Road> iterator = roads.iterator();
		
		while (iterator.hasNext()) {
			
			Road road = iterator.next(); 
			
			boolean containsSource = road.contains(vertex);
			
			if (containsSource == true) { 
				
				edges.add(road);
			}
			
		}
		
		return edges;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		
		Road newRoad = new Road(sourceVertex, destinationVertex, weight, description); 
		
		for (Road road: roads) {
			
			if (road.equals(newRoad)) {
				roads.remove(road);
				return road;
			}
		}
		
		
		return null;
	}

	@Override
	public boolean removeVertex(Town v) {
		
		if (towns.contains(v) == false) {
			return false;
		}
		
		Iterator<Road> iterator = roads.iterator();
		
		while(iterator.hasNext()) {
			
			Road road = iterator.next(); 
			
			if (road.contains(v) == true) { 
				
				iterator.remove();
			}
		}
		
		return towns.remove(v);
	
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {

		
		distances.clear();
		predecessors.clear();
		
		dijkstraShortestPath(sourceVertex);
		
		if (!distances.containsKey(destinationVertex) ||distances.get(destinationVertex) == Integer.MAX_VALUE ) {
			
			return new ArrayList<>();
		}
		
		Stack<Town> stack = new Stack<>();
		Town currentTown = destinationVertex;
		
		while (currentTown != null) {
			
			stack.push(currentTown);
			currentTown = predecessors.get(currentTown);
			
        }
		
		ArrayList<String> finalPath = new ArrayList<>();
		
		while(stack.size() > 1) {
			
			Town initialTown = stack.pop();
			Town destinationTown = stack.peek();
			
			Road road = getEdge(initialTown, destinationTown);
			
			if (road !=null) {
				finalPath.add(initialTown.getName() + " via " + road.getName() + " to " + destinationTown.getName() + " " + road.getWeight() + " mi");
			}
			
		}
		
		return finalPath;
			

	}


	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		
		distances.clear();
		predecessors.clear();
		
		Iterator<Town> townIterator = towns.iterator();
		
		while(townIterator.hasNext()) {
			
			Town currentTown = townIterator.next();
			
			distances.put(currentTown, Integer.MAX_VALUE);
			predecessors.put(currentTown, null);
			
		}
		
		distances.put(sourceVertex, 0);
		
		PriorityQueue<TownDistance> priorityQueue = new PriorityQueue<>();
		
		priorityQueue.add(new TownDistance(sourceVertex, 0));
		
		Set<Town> doneTowns = new HashSet<>();
		
		
		while (priorityQueue.isEmpty() == false) {
			
			TownDistance current = priorityQueue.poll();
			Town currentTown = current.town;
			
			
			if (doneTowns.contains(currentTown)){ 
		
				continue;
			} 
			
			doneTowns.add(currentTown);
			
			
			Iterator<Road> roadIterator = roads.iterator();
			while (roadIterator.hasNext()) {
				
				Road road = roadIterator.next();
				
				if (road.contains(currentTown)) {
					
					Town neighboringTown = null;
					
					if (road.getSource().equals(currentTown)) {
						neighboringTown = road.getDestination();
					}
					else if (road.getDestination().equals(currentTown)) {
						neighboringTown = road.getSource();
					}
					
					int distanceToNeighboringTown = distances.get(currentTown) + road.getWeight();
					
					if (distanceToNeighboringTown < distances.get(neighboringTown)) {
						
						distances.put(neighboringTown, distanceToNeighboringTown);
						predecessors.put(neighboringTown, currentTown);
						priorityQueue.add(new TownDistance(neighboringTown, distanceToNeighboringTown));
					}
				}
			}
			
			
		}
		
	}
	

	private class TownDistance implements Comparable<TownDistance>{ 
		
		Town town;
		int distance;
		
		TownDistance(Town town, int distance){
			
			this.town = town;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(TownDistance other) {
			return Integer.compare(this.distance, other.distance);
		}
	}

}
































