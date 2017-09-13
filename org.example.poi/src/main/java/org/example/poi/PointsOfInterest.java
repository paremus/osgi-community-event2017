package org.example.poi;

import java.util.List;

public interface PointsOfInterest {
	
	static final class POI {
		public float latitude;
		public float longitude;
		public String label;
		@Override
		public String toString() { return String.format("POI '%s':lat=%f;long=%f", label, latitude, longitude); }
	}

	List<POI> find(String search) throws Exception;
	
}
