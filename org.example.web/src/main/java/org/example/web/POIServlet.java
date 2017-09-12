package org.example.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;

@Component(
		property = {
				HttpWhiteboardConstants.HTTP_WHITEBOARD_RESOURCE_PATTERN + "=/*",
				HttpWhiteboardConstants.HTTP_WHITEBOARD_RESOURCE_PREFIX + "=/static",
				HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_PATTERN + "=/servlet"
		})
public class POIServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String query = req.getQueryString();
		if (query == null || query.trim().isEmpty()) query = "";

		try (OutputStream out = resp.getOutputStream()) {
			// TODO: delete code below, replace with code to search for POIs and serialize as JSON to the browser
			new PrintStream(out).println("[]"); // empty JSON array
		} catch (Exception e) {
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

}
