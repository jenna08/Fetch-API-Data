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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;




//@WebServlet("/GetUserServlet")
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
		
		// Method 1
		/*
		 * String userName = request.getParameter("userName").trim(); if(userName ==
		 * null || "".equals(userName)){ userName = "Guest"; }
		 * 
		 * String greetings = "Hello " + userName;
		 * 
		 * response.setContentType("text/plain"); response.getWriter().write(greetings);
		 */
		 
		
		/* Method 2
		 * List<String> list = new ArrayList<>(); list.add("item1"); list.add("item2");
		 * list.add("item3"); String json = new Gson().toJson(list);
		 * 
		 * response.setContentType("application/json");
		 * response.setCharacterEncoding("UTF-8"); response.getWriter().write(json);
		 */
	}

	private String testMethod(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		URLConnection connection = null;
		BufferedReader reader=null;
		StringBuilder strBuf = new StringBuilder(); 
		
		try {
			connection = new URL("https://reqres.in/api/users/2").openConnection();
			//log.debug("url-> "+connection.getURL());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.setRequestProperty("Accept", "application/json");
		//log.debug("connection set");
		//Get Response  
		try {
			
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
			//log.debug("reader-> "+reader);
            String output = null;  
            while ((output = reader.readLine()) != null) {  
                strBuf.append(output);  
            }
            
           
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return strBuf.toString();
	}

	/*
	 * private void getAccessToken() { HttpHeaders requestHeaders = new
	 * HttpHeaders();
	 * requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 * requestHeaders.add("X-ENVIRONMENT",loginParam.getEnvironment()); String
	 * plainClientCredentials = loginParam.getClientKey()+
	 * ":"+loginParam.getSecretKey(); RestTemplate objRestTemplate = new
	 * RestTemplate(); requestHeaders.add("Authorization","Basic " +
	 * DatatypeConverter.printBase64Binary(plainClientCredentials.getBytes("UTF-8"))
	 * ); HttpEntity<?> httpEntity = new HttpEntity<Object>(requestHeaders); String
	 * endpointUrl=loginParam.getApiEndpoint()+"accesstoken";
	 * //log.debug("Invite Endpoint URL :"+endpointUrl); ResponseEntity<Object>
	 * response = objRestTemplate.exchange(endpointUrl, HttpMethod.GET,httpEntity,
	 * Object.class); LinkedHashMap<String, Object> map = (LinkedHashMap<String,
	 * Object>) response.getBody(); //return (String) map.get("accessToken"); }
	 */
}
