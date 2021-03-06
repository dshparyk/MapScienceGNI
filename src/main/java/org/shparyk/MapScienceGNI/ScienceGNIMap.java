package org.shparyk.MapScienceGNI;

import java.util.HashMap;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

/**
 * Visualizes level of GNI, number of researchers in R&D, Scientific and technical journal articles in different countries. 
 * 
 * It loads the country shapes from a GeoJSON file via a data reader, and loads the above data level values from
 * another CSV files (provided by the World Bank). The data value is encoded to transparency via a simplistic linear
 * mapping.
 */

public class ScienceGNIMap extends PApplet{
	
	UnfoldingMap map;
	
	HashMap<String, Float> gniMap;
	HashMap<String, Float> researchesMap;
	HashMap<String, Float> scientificMap;
	
	List<Feature> countries;
	List<Marker> countryMarkers;
	
	public void setup() {
		size(800, 600, OPENGL);
		map = new UnfoldingMap(this, 50, 50, 700, 500, new Microsoft.AerialProvider()); 
		MapUtils.createDefaultEventDispatcher(this, map);
		System.out.println("Test1");
		gniMap = ParseFeed.loadGNIFromCSV(this, "GNIPPPWorldBank.csv");
		System.out.println("Test2");
		researchesMap = ParseFeed.loadResearchesFromCSV(this, "ResearchersWorldBank.csv");
		scientificMap = ParseFeed.loadScientificFromCSV(this, "ScientificJournalsWorldBank.csv");
		countries = GeoJSONReader.loadData(this, "countries.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries);
		map.addMarkers(countryMarkers);
		System.out.println(countryMarkers.get(0).getId());
		
		shadeGNI();
	}

	public void draw() {
		background(57, 233, 239);
		map.draw();
	}
	
	private void shadeGNI() {
		for (Marker marker : countryMarkers) {
			// Find data for country of the current marker
			String countryId = marker.getId();
			System.out.println(gniMap.containsKey(countryId));
			if (gniMap.containsKey(countryId)) {
				float gni = gniMap.get(countryId);
				// Encode value as brightness (values range: 40-90)
				int colorLevel = (int) map(gni, 230, 141000, 10, 255);
				marker.setColor(color(255-colorLevel, 100, colorLevel));
			}
			else {
				marker.setColor(color(150,150,150));
			}
		}
	}
}
