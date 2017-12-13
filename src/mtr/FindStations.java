package mtr;

import java.util.Queue;
import java.util.Set;

import javax.security.auth.kerberos.KerberosKey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
//import jss2.QueueADT;

public class FindStations {

	// private HashMap<String, ArrayList<String>> map;
	private static ReadFile k;

	public FindStations() {
		// map = new HashMap<String, ArrayList<String>>();
		// k = new fileReader();

	}

	public static void main(String[] args) {

		// HashMap<String, ArrayList<String>> map = new HashMap<String,
		// ArrayList<String>>();
		k = new ReadFile();
		// listStationsInLine();
		k.csvReader();

		ArrayList<String> Stations = new ArrayList<String>();

		String line = "West Rail Line";
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
			System.out.println(stationName);
		}

	}
}