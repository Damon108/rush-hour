package mtr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class ReadFile {

	public HashMap<String, ArrayList<String>> stationMap;
	public BufferedReader br;

	public HashMap<String, ArrayList<String>> getStationMap() {

		return stationMap;
	}

	public void something() {
		String splitBy = ",";
		String line;
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
}
