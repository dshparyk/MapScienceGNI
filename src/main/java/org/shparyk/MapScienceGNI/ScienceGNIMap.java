package org.shparyk.MapScienceGNI;

import java.util.HashMap;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.marker.Marker;
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
		size(800, 700, OPENGL);
		map = new UnfoldingMap(this, 50, 125, 700, 500, new Microsoft.AerialProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
	}
	
	public void draw() {
		background(57, 233, 239);
		map.draw();
	}
}
