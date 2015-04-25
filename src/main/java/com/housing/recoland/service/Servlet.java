package com.housing.recoland.service;


import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

	private static final long serialVersionUID = -6154475799000019575L;
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username=URLDecoder.decode(request.getParameter("username"),"UTF-8");
    	response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
        String output = null;
        try {
            output = RecoLandService.getRecommendedLands(username);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.getWriter().println(output);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		this.doGet(request, response);
	}
}