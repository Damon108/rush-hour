
  package mtr;
  
  import java.util.HashSet; import java.util.Map; import java.util.ArrayList;
  import java.util.Collections;
  
  public class StationConnections {
  
  public HashSet<String> hset1; 
  public HashSet<String> hset2; 
  public ReadFile h;
  
  public static void main(String[] args) {
  
  
   ReadFile h = new ReadFile(); 
   HashSet<String> hset1 = new HashSet<String>(); 
   HashSet<String> hset2 = new HashSet<String>();
  
  h.csvReader();
  
  String hello = "West Rail Line";
  
  for (String w : h.getStationMap().keySet()) { if (hello.matches(w)) {
  
  hset2 = new HashSet<String>(h.getStationMap().get(hello));
  
  break;
  
  } else {
  
  }
  
  }
  
  for (Map.Entry<String, ArrayList<String>> entry :
  h.getStationMap().entrySet()) {
  
  hset1 = new HashSet<String>(entry.getValue()); boolean result =
  !Collections.disjoint(hset1, hset2); if (result == true &&
  (!(entry.getKey().contains(hello)))) { System.out.println(entry.getKey()); }
  
  }
  
  } }
 