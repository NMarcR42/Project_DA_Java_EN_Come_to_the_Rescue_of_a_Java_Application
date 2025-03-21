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
	
	// step 2
	public List<String> getSymptoms(){
		return reader.GetSymptoms();
	}
	
	// step 3
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		 // we need convert the list into a Map to count
		 Map<String, Integer> symptomsCount = new HashMap<>();
		 // for () element in elements
		 // symptomsCount ++;
		 // return symptomsCount;
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
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		
		AnalyticsCounter analyctics1 = new AnalyticsCounter(reader, writer);
		
		
	}
}
