package mtr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import mtr.PathFinderTreeNode;

/*
 * private HashMap<String, ArrayList<String>> stationMap; private
 * BufferedReader br; private ReadFile k; private String line; private
 * HashSet<String> hset1; private HashSet<String> hset2;
 * 
 * 
 * 
 * private HashMap<String, ArrayList<String>> getStationMap() {
 * 
 * return stationMap; }
 * 
 * 
 * private void csvReader() throws IOException { String splitBy = ","; line
 * = " "; stationMap = new HashMap<String, ArrayList<String>>(); // Creates
 * a new // HashMap
 * 
 * try { BufferedReader br = new BufferedReader(new
 * FileReader("MTRsystem_partial.csv")); // Creates // new // Buffered //
 * Reader while ((line = br.readLine()) != null) { // Checks to see if the
 * // line is empty String[] station = line.split(splitBy); // if it isn't
 * then the // words within the file // are stored in the // string array
 * ArrayList<String> stationStops = new ArrayList<String>(); // new // Array
 * // List // created Collections.addAll(stationStops, station); // moves
 * the strings // stored in the // station array to // the stationStops //
 * ArrayList stationStops.remove(0); // removes the first element which is
 * // the station name from the ArrayList stationMap.put(station[0],
 * stationStops); // Maps the stations // and the stations // stops to a //
 * HashMap
 * 
 * } br.close();
 * 
 * } catch (IOException e) {
 * 
 * }
 * 
 * }
 */
public class PathFinderTree<T> implements Iterable<T> {
	protected PathFinderTreeNode<T> root;
	protected static class PathFinderTreeNode<String> {
		public String element;
		public PathFinderTreeNode<String> left;
		public PathFinderTreeNode<String> right;
		

		// Constructor:
		public PathFinderTreeNode(String element) {
			this.element = element;
			left = null; // no children
			right = null;
		}

		/*
		 * Definition of other constructor omitted.
		 */

		public boolean isLeaf() {
			return (left == null && right == null);
		}
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
