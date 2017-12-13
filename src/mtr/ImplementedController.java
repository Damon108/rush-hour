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

	private HashMap<String, ArrayList<String>> stationMap;
	private BufferedReader br;
	private ReadFile k;
	private String line;
	private HashSet<String> hset1;
	private HashSet<String> hset2;

	public ImplementedController() {
		k = new ReadFile();
		k.csvReader();
	}

	private HashMap<String, ArrayList<String>> getStationMap() {

		return stationMap;
	}

	private void csvReader() throws IOException {
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

	public String listAllTermini() {
		// k.csvReader();
		String termini = "";
		System.out.println("List of all Termini");
		for (Map.Entry<String, ArrayList<String>> entry : k.getStationMap().entrySet()) {
			int lastStation = entry.getValue().size() - 1;
			termini += entry.getKey() + " : " + entry.getValue().get(0) + " , " + entry.getValue().get(lastStation)
					+ "\n";
		}
		// System.out.println(line);
		return termini;

	}

	public String listStationsInLine(String line) {
		k.csvReader();
		this.line = line;

		ArrayList<String> Stations = new ArrayList<String>();

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
			line += "\n" + stationName;
		}
		return line;
	}

	public String listAllDirectlyConnectedLines(String line) {
		String directlyConencted = "";
		HashSet<String> hset1 = new HashSet<String>();
		HashSet<String> hset2 = new HashSet<String>();

		for (String w : k.getStationMap().keySet()) {
			if (line.matches(w)) {

				hset2 = new HashSet<String>(k.getStationMap().get(line));

				break;

			} else {

			}

		}

		for (Map.Entry<String, ArrayList<String>> entry : k.getStationMap().entrySet()) {

			hset1 = new HashSet<String>(entry.getValue());
			boolean result = !Collections.disjoint(hset1, hset2);
			if (result == true && (!(entry.getKey().contains(line)))) {
				directlyConencted += "\n" + entry.getKey() + " ";
			}

		}
		return directlyConencted;
	}

	// TODO : THE KILLER MATE
	public String showPathBetween(String stationA, String stationB) {

		return "Help";
	}
}
