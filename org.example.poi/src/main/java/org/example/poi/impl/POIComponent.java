package org.example.poi.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.example.poi.PointsOfInterest;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component
public class POIComponent implements PointsOfInterest {
	
	private final List<POI> pois = new ArrayList<>();
	
	@Activate
	void activate() throws Exception {
		InputStream resource = getClass().getResourceAsStream("/data.csv");
		if (resource == null) throw new IllegalStateException("Missing data resource");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource))) {
			reader.lines()
				.map(s -> s.split(",", 3))
				.map(ss -> {
					if (ss.length != 3) throw new IllegalArgumentException("Not enough fields: " + Arrays.toString(ss));
					POI poi = new POI();
					poi.latitude = Float.parseFloat(ss[0]);
					poi.longitude = Float.parseFloat(ss[1]);
					poi.label = ss[2];
					return poi;
				})
				.forEach(pois::add);
		}
	}

	@Override
	public List<POI> find(String search) throws Exception {
		Pattern pattern = Pattern.compile(search.toLowerCase().replaceAll("\\*", ".*"));
		return pois.stream()
				.filter(poi -> pattern.matcher(poi.label.toLowerCase()).find())
				.collect(Collectors.toList());
	}

}
