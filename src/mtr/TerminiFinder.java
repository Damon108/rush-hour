package mtr;

import java.util.ArrayList;

import java.util.Map;

public class TerminiFinder {

	public ReadFile k;

	public void terminiFinder1() {
		ReadFile k = new ReadFile();
		k.csvReader();
		System.out.println("List of all Termini");
		for (Map.Entry<String, ArrayList<String>> entry : k.getStationMap().entrySet()) {
			int lastStation = entry.getValue().size() - 1;
			System.out.println(
					entry.getKey() + " : " + entry.getValue().get(0) + " , " + entry.getValue().get(lastStation));
		}

	}

}
