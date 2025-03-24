package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {	
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	// Constructor
	public AnalyticsCounter(ISymptomReader reader,ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	
	// Get the list of all the symptom in the file
	public List<String> getSymptoms(){
		return reader.GetSymptoms();
	}
	
	// Count the number of each symptom in the file group by key + value
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		 // we need convert the list into a Map to count
		 Map<String, Integer> symptomsCount = new HashMap<>();
		 for (String symptom : symptoms) {
			 if(symptomsCount.containsKey(symptom)) {
				 symptomsCount.put(symptom, symptomsCount.get(symptom)+1); //increment the value of the key
			 }else {
				 symptomsCount.put(symptom, 1); // if the key doesn't exist in the map, then we add it with default value 1
			 }
		 }
		 return symptomsCount;
	}
	 
	// sort each symptom in order with TreeMap
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		 return new TreeMap<>(symptoms);
		 //Collections.sort(symptoms); can't use sort here since it's a Map
	}
	 
	// Write the result in a file
	public void writeSymptoms(Map<String, Integer> symptoms) { 
		 writer.writeSymptoms(symptoms);
	}
	
	public static void main(String args[]) throws Exception {
		// Create an  object to read a specific file and write a new file
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		
		// Create an object to execute our method
		AnalyticsCounter analyctics1 = new AnalyticsCounter(reader, writer);
		
		// execute the methods in order
		List<String> symptoms = analyctics1.getSymptoms();
		Map<String, Integer> sympCount = analyctics1.countSymptoms(symptoms);
		Map<String, Integer> sortSymp = analyctics1.sortSymptoms(sympCount);
		analyctics1.writeSymptoms(sortSymp);
		
		
		
	}
}
