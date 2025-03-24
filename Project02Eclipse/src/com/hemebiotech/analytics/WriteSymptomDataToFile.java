package com.hemebiotech.analytics;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
	private String filepath;
	
	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		// TODO Auto-generated method stub
		// Check if our Map is empty before trying to write in our file
		if(symptoms == null || symptoms.isEmpty()) {
			System.out.println("No data to write in the file, the Map is may be empty.");
			return;
		}
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))){
			for(Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				writer.write(entry.getKey() + ":" + entry.getValue()); 
				writer.newLine();
				/**
				 * We use a buffer like the reader file to make the treatment faster
				 * write directly the key & value in the map
				 */
			}
			System.out.println("The data have been inserted in " + filepath);
		}
		catch(IOException e) {
			System.err.println("Error, the file has not been updated :" + e.getMessage()); // Return the error message
		}
		
	}

}
