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
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))){
			for(Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				writer.write(entry.getKey() + ":" + entry.getValue()); 
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
