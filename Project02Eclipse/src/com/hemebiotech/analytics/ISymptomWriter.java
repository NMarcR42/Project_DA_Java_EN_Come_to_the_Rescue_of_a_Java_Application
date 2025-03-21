package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
	void writeSymptoms(Map<String, Integer> symptoms); 

	/**
	 * We use a Map here because we want to know for 
	 * Map -> Key string, value int
	 * key -> headache,rash,...
	 * value-> number of 
	 */
}
