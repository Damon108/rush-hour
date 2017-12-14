package mtr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;

public class ImplementedController implements Controller {
   // Creates a new Hashmap 
	private HashMap<String, ArrayList<String>> stationMap;

	public ImplementedController() throws IOException {

		stationMap = new HashMap<String, ArrayList<String>>();
		csvReader();
	}

	private void csvReader() throws IOException {
		String splitBy = ",";
		String line;
		// Creates new Buffered Reader
		BufferedReader br = new BufferedReader(new FileReader("MTRsystem_partial.csv")); 
		// Checks to see if the	line is empty
		while ((line = br.readLine()) != null) { 
			// if it isn't then the words within the file are stored in the string array
			String[] station = line.split(splitBy);
			// new Array List created
			ArrayList<String> stationStops = new ArrayList<String>(); 
			// moves the strings stored in the station array to the stationStops ArrayList
			Collections.addAll(stationStops, station); 
			// removes the first element which is the station name from the ArrayList
			stationStops.remove(0); 
			// Maps the stations and the stations stops to a HashMap
			stationMap.put(station[0], stationStops);
		}
		br.close();

	}

	
	// Returns the hashmap of the stored values
	private HashMap<String, ArrayList<String>> getStationMap() {

		return stationMap;
	}
	

	public String listAllTermini() {
		String termini = "";
		System.out.println("List of all Termini:");
		//Loops over the Hashmap and retrieves first and final value
		for (Map.Entry<String, ArrayList<String>> entry : stationMap.entrySet()) {
			int lastStation = entry.getValue().size() - 1;
			termini += entry.getKey() + " : " + entry.getValue().get(0) + " , " + entry.getValue().get(lastStation)
					+ "\n";
		}
		return termini;
	}

	public String listStationsInLine(String line) {
		try {
			String listStations = line + ": ";
			ArrayList<String> stations = new ArrayList<String>();
			//Loops over the Hashmap and checkers whether the line exists
			for (Map.Entry<String, ArrayList<String>> entry : stationMap.entrySet()) {
				if (entry.getKey().equals(line)) {
					stations = entry.getValue();
				}
			}
			//Throws an exception if name is not found
			if (stations.isEmpty()) {
				throw new Exception("Line doesnt exist");
			}

			for (int i = 0; i < stations.size(); i++) {
				String stationName = stations.get(i);
				int k = i + 1;
				//Adds the station name to the string tthat is to be printed out
				listStations += stationName;
				if (k < stations.size()) {
					listStations += " <-> ";
				} else {

				}
			}
			//returns the string of stations in a line
			return listStations;
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public String listAllDirectlyConnectedLines(String line) {
		try {
			String directlyConencted = line + " is connected to:";
			//creates the hash sets to store the different stations that are to be compared
			HashSet<String> comparisonLine = new HashSet<String>();
			HashSet<String> choosenLine = new HashSet<String>();
            //checks whether the station line exists
			for (String stationLine : getStationMap().keySet()) {
				if (line.matches(stationLine)) {
				//Assigns the found line to the variable comparison line to be compared against
					comparisonLine = new HashSet<String>(getStationMap().get(line));
					break;
				}
			}

			if (comparisonLine.isEmpty()) {
				throw new Exception("Line doesnt exist");
			}
			//checks to see if the chosen line has the same lines as the comparison line
			for (Map.Entry<String, ArrayList<String>> entry : getStationMap().entrySet()) {
				choosenLine = new HashSet<String>(entry.getValue());
				//Returns a boolean value based on checking whether the two sets have the same stations
				boolean result = !Collections.disjoint(choosenLine, comparisonLine);
				//checks if the line doesn't already exist
				if (result == true && (!(entry.getKey().contains(line)))) {
					directlyConencted += "\n" + entry.getKey() + " ";
				}
			}
			return directlyConencted;
		} catch (Exception e) {
			//prints error message
			return e.getMessage();
		}
	}

	public String showPathBetween(String stationA, String stationB) {

		return null;

	}
}
