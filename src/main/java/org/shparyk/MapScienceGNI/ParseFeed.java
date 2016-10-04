package org.shparyk.MapScienceGNI;

import java.util.HashMap;

import processing.core.PApplet;

public class ParseFeed {
	
	
	/*
	 * This method is to parse a file containing GNI PPP information from
	 * the world bank.  
	 * The file and its format can be found: 
	 * http://data.worldbank.org/indicator/NY.GNP.PCAP.PP.CD
	 * 
	 * It is also included with the package 
	 * in the file GNIPPPWorldBank.csv
	 * 
	 * @param p - PApplet being used
	 * @param fileName - file name or URL for data source
	 * @return A HashMap of country->GNI PPP
	 */
	public static HashMap<String, Float> loadGNIFromCSV(PApplet p, String fileName) {
		HashMap<String, Float> gniMap = new HashMap<String, Float>();
		String[] rows = p.loadStrings(fileName);
		// Reads country name and GNI value from CSV row
		//for (String row : rows) {
		for (int i = 5; i < rows.length; i++) {
			// split row by commas not in quotations
			String[] columns = rows[i].split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			System.out.println("row " + i);
			// check if there is any GNI data from any year, get most recent
			for(int j = columns.length - 1; j > 33; j--) {
				// check if value exists for year
				if(isNumeric(columns[j])) {
					System.out.println("Test16" + columns[j]);
					gniMap.put(columns[1], Float.parseFloat(columns[i]));
					// break once most recent data is found
					break;
				}
			}
		}
		return gniMap;
	}
	
	/*
	 * This method is to parse a file containing Researchers in R&D per country 
	 * information from the world bank.  
	 * The file and its format can be found: 
	 * http://data.worldbank.org/indicator/SP.POP.SCIE.RD.P6
	 * 
	 * It is also included with the package 
	 * in the file ResearchersWorldBank.csv
	 * 
	 * @param p - PApplet being used
	 * @param fileName - file name or URL for data source
	 * @return A HashMap of country->Researchers in R&D (per million people)
	 */
	public static HashMap<String, Float> loadResearchesFromCSV(PApplet p, String fileName) {
		HashMap<String, Float> researchesMap = new HashMap<String, Float>();
		return researchesMap;
	}
	
	/*
	 * This method is to parse a file containing Scientific and technical journal articles per country 
	 * information from the world bank.  
	 * The file and its format can be found: 
	 * http://data.worldbank.org/indicator/IP.JRN.ARTC.SC
	 * 
	 * It is also included with the package 
	 * in the file ScientificJournalsWorldBank.csv
	 * 
	 * @param p - PApplet being used
	 * @param fileName - file name or URL for data source
	 * @return A HashMap of country->number of Scientific and technical journal articles
	 */
	public static HashMap<String, Float> loadScientificFromCSV(PApplet p, String fileName) {
		HashMap<String, Float> scientificMap = new HashMap<String, Float>();
		return scientificMap;
	}
	
	public static boolean isNumeric(String str)
	{
		try  
		  {  
		    float f = Float.parseFloat(str);  
		  }  
		  catch(NumberFormatException nfe)  
		  {  
		    return false;  
		  }
		return true;
	}
	
}
