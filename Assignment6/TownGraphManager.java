

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TownGraphManager implements TownGraphManagerInterface{

	private Graph graph;
	
	public TownGraphManager() {
		graph = new Graph();
	}
	
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		
		Town t1 = getTown(town1);
		Town t2 = getTown(town2);
		
		if (t1 == null || t2 == null) {
			return false;
		}
		
		return graph.addEdge(t1, t2, weight, roadName) != null;
	}

	@Override
	public String getRoad(String town1, String town2) {
		
		Town t1 = getTown(town1);
		Town t2 = getTown(town2);
		
		if (t1 == null || t2 == null) {
			return null;
		}
		
		Road road = graph.getEdge(t1, t2);
		
		if (road != null) {
			return road.getName();
		}
		else {
			return null;
		}
	}

	@Override
	public boolean addTown(String v) {
		
		Town town = new Town(v);
		
		return graph.addVertex(town);

		
	}

	@Override
	public Town getTown(String name) {


		for(Town town: graph.vertexSet()) {
			
			if (town.getName().equals(name)) {
				return town;
			}
		}
		
		return null;
	}

	@Override
	public boolean containsTown(String v) {
		
		return getTown(v) != null;
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		
		return getRoad(town1, town2) != null;
	}

	@Override
	public ArrayList<String> allRoads() {
		
		ArrayList<String> roads = new ArrayList<>();
		
		for (Road road: graph.edgeSet()) {
			roads.add(road.getName());
		}
		
		
		Collections.sort(roads);
		return roads;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {

		Town t1 = getTown(town1);
		Town t2 = getTown(town2);
		
		if (t1 == null || t2 == null) {
			return false;
		}
		
		Road roadToBeremoved = graph.getEdge(t1,t2);
		
		if(roadToBeremoved != null && roadToBeremoved.getName().equals(road)) {
			
			
			return graph.removeEdge(t1, t2, roadToBeremoved.getWeight(), roadToBeremoved.getName()) != null;
		}
		
		return false;
		
	}

	@Override
	public boolean deleteTown(String v) {
		
		Town town = getTown(v);
		
		if(town == null) {
			return false;
		}
		
		return graph.removeVertex(town);
	}

	@Override
	public ArrayList<String> allTowns() {
		
		ArrayList<String> towns = new ArrayList<>();
		
		for (Town town: graph.vertexSet()) {
			towns.add(town.getName());
		}
		
		
		Collections.sort(towns);
		return towns;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {

		Town t1 = getTown(town1);
		Town t2 = getTown(town2);
		
		if (t1 == null || t2 == null) {
			return null;
		}
		
		ArrayList<String> shortest = graph.shortestPath(t1, t2);
		
		return shortest;
	}
	
	
	public void readFile(String fileName) throws FileNotFoundException, IOException, java.io.FileNotFoundException  {
		
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNextLine())  {
			
			int weight;
			
			String line = scanner.nextLine().trim();
			
			
			String[] roadParts = line.split(",", 2);
			if (roadParts.length != 2) {
				
				continue;
			}
			String roadName = roadParts[0].trim();
			
			
			
			String[] townParts = roadParts[1].split(";");
			if (townParts.length != 3) {
				
				continue;
			}
			
			Scanner numScanner = new Scanner(townParts[0].trim());
			
			if (numScanner.hasNextInt() == false) {
				numScanner.close();
				continue;
			}

			
			weight = numScanner.nextInt();
			numScanner.close();
				
			
			String town1 = townParts[1].trim();
			String town2 = townParts[2].trim();
			
			addTown(town1);
			addTown(town2);
			addRoad(town1, town2,weight, roadName);
		}
		
		scanner.close();
	}

	public void populateTownGraph(File selectedFile) {
		try {
	        readFile(selectedFile.getAbsolutePath());
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
	}

}































