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

	public HashMap<String, ArrayList<String>> stationMap;
	public BufferedReader br;
	public ReadFile k;
	private String line;
	public HashSet<String> hset1;
	public HashSet<String> hset2;

	public ImplementedController() {
		k = new ReadFile();
		String splitBy = ",";
		line = " ";
		stationMap = new HashMap<String, ArrayList<String>>(); // Creates a new
																// HashMap

		try {
			BufferedReader br = new BufferedReader(new FileReader("MTRsystem_partial.csv")); // Creates
																								// new
																								// Buffered
																								// Reader
			while ((line = br.readLine()) != null) { // Checks to see if the
														// line is empty
				String[] station = line.split(splitBy); // if it isn't then the
														// words within the file
														// are stored in the
														// string array
				ArrayList<String> stationStops = new ArrayList<String>(); // new
																			// Array
																			// List
																			// created
				Collections.addAll(stationStops, station); // moves the strings
															// stored in the
															// station array to
															// the stationStops
															// ArrayList
				stationStops.remove(0); // removes the first element which is
										// the station name from the ArrayList
				stationMap.put(station[0], stationStops); // Maps the stations
															// and the stations
															// stops to a
															// HashMap

			}
			br.close();

		} catch (IOException e) {

		}

	}

	public HashMap<String, ArrayList<String>> getStationMap() {

		return stationMap;
	}

	/*
	 * public void something() { String splitBy = ","; line = " "; stationMap =
	 * new HashMap<String,ArrayList<String>>(); // Creates a new HashMap
	 * 
	 * try { BufferedReader br = new BufferedReader(new
	 * FileReader("MTRsystem_partial.csv")); // Creates new Buffered Reader
	 * while((line = br.readLine()) != null){ // Checks to see if the line is
	 * empty String[] station = line.split(splitBy); // if it isn't then the
	 * words within the file are stored in the string array ArrayList<String>
	 * stationStops = new ArrayList<String>(); // new Array List created
	 * Collections.addAll(stationStops, station); //moves the strings stored in
	 * the station array to the stationStops ArrayList stationStops.remove(0);
	 * // removes the first element which is the station name from the ArrayList
	 * stationMap.put(station[0], stationStops); //Maps the stations and the
	 * stations stops to a HashMap
	 * 
	 * } br.close();
	 * 
	 * } catch (IOException e) {
	 * 
	 * }
	 * 
	 * }
	 */

	public String listAllTermini() {
		// k.something();
		System.out.println("List of all Termini");
		for (Map.Entry<String, ArrayList<String>> entry : k.getStationMap().entrySet()) {
			int lastStation = entry.getValue().size() - 1;
			line = entry.getKey() + " : " + entry.getValue().get(0) + " , " + entry.getValue().get(lastStation);
		}
		return line;

	}

	public String listStationsInLine(String line) {
		this.line = line;

		ArrayList<String> Stations = new ArrayList<String>();

		System.out.println(line + ": ");
		for (Map.Entry<String, ArrayList<String>> entry : k.getStationMap().entrySet()) {

			if (entry.getKey().equals(line)) {
				// int g = entry.getValue().size() - 1;
				/*
				 * for (int i = 0; i < k.getStationMap().size(); i++) { String
				 * stationLine = entry.getKey(); String stationName =
				 * entry.getValue().get(i); System.out.println(stationName);
				 */

				Stations = entry.getValue();

			}
		}

		for (int i = 0; i < Stations.size(); i++) {
			// String stationLine = entry.getKey();
			String stationName = Stations.get(i);
			line += stationName + " ";
		}
		return line;
	}

	public String listAllDirectlyConnectedLines(String line) {

		HashSet<String> hset1 = new HashSet<String>();
		HashSet<String> hset2 = new HashSet<String>();

		String hello = "East Rail Line";

		for (String w : getStationMap().keySet()) {
			if (hello.matches(w)) {

				hset2 = new HashSet<String>(getStationMap().get(hello));

				break;

			} else {

			}

		}

		for (Map.Entry<String, ArrayList<String>> entry : getStationMap().entrySet()) {

			hset1 = new HashSet<String>(entry.getValue());
			boolean result = !Collections.disjoint(hset1, hset2);
			if (result == true && (!(entry.getKey().contains(hello)))) {
				line += entry.getKey() + " ";
			}

		}
		return line;
	}

	// TODO : THE KILLER MATE
	public String showPathBetween(String stationA, String stationB) {

		return "Help";
	}
}
