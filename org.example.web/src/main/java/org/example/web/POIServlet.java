package org.example.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.poi.PointsOfInterest;
import org.example.poi.PointsOfInterest.POI;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component(
		property = {
				HttpWhiteboardConstants.HTTP_WHITEBOARD_RESOURCE_PATTERN + "=/*",
				HttpWhiteboardConstants.HTTP_WHITEBOARD_RESOURCE_PREFIX + "=/static",
				HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_PATTERN + "=/servlet"
		})
public class POIServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Reference
	PointsOfInterest poiSvc;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String query = req.getQueryString();
		if (query == null || query.trim().isEmpty()) query = "";

		try (OutputStream out = resp.getOutputStream()) {
			List<POI> pois = poiSvc.find(query);
			mapper.writeValue(out, pois);
		} catch (Exception e) {
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

}
