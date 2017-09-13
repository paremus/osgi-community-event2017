package org.example.poi.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.example.poi.PointsOfInterest.POI;
import org.junit.Test;

public class POIComponentTest {

	@Test
	public void test() throws Exception {
		// This doesn't really test the component, it only shows the component is testable in plain JUnit
		POIComponent component = new POIComponent();
		component.activate();
		
		List<POI> pois = component.find("*");
		assertNotNull(pois);
	}

}
