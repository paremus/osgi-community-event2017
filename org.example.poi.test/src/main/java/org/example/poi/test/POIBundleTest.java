package org.example.poi.test;

import static org.junit.Assert.*;

import org.example.poi.PointsOfInterest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

public class POIBundleTest {

	private final BundleContext context = FrameworkUtil.getBundle(POIBundleTest.class).getBundleContext();

	private ServiceTracker<PointsOfInterest, PointsOfInterest> poiTracker;
	
	@Before
	public void before() {
		poiTracker = new ServiceTracker<>(context, PointsOfInterest.class, null);
		poiTracker.open(true);
	}
	@After
	public void after() {
		poiTracker.close();
	}

	@Test
	public void testExample() throws Exception {
		PointsOfInterest pois = poiTracker.waitForService(1000);
		assertNotNull("POI service not found", pois);
		assertNotNull("POI search returned null", pois.find("*"));
	}

}
