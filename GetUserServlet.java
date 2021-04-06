package com.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class GetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String result = testMethod(request, response);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().write(result);
		//out.print(result);
		//out.flush();
	}

	private String testMethod(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		URLConnection connection = null;
		BufferedReader reader=null;
		StringBuilder strBuf = new StringBuilder(); 
		
		try {
			connection = new URL("https://reqres.in/api/users/2").openConnection();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.setRequestProperty("Accept", "application/json");
		
		//Get Response  
		try {
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
			
            		String output = null;  
            		while ((output = reader.readLine()) != null) {  
                		strBuf.append(output);  
            		}
            	} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return strBuf.toString();
	}

}
