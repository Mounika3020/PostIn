package com.iss.servlets;
import java.io.*;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iss.models.*;
import com.iss.services.*;
import com.oreilly.servlet.*;

public class MyFriendsPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String Title;
	String Category;
	String Description;
	String Location;
	byte[] imagebyte;
	 public MyFriendsPostServlet() { 	
	    	
	    	
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyFriendsPost myfriendspost=new MyFriendsPost();
		try {
			System.out.println(getServletContext().getRealPath(""));
			MultipartRequest multipartrequest=new MultipartRequest(request,getServletContext().getRealPath(""));
			if(multipartrequest.getParameter(Title)==null)
			{
				Title=multipartrequest.getParameter("Title");
				Category=multipartrequest.getParameter("Category");
				Description=multipartrequest.getParameter("Description");
		        Location=multipartrequest.getParameter("Location");
				File file=multipartrequest.getFile("image");
				File copiedfile=new File(getServletContext().getRealPath("")+"//"+file.getName());
				FileInputStream fileinputstream=new FileInputStream(copiedfile);
				imagebyte=fileinputstream.readAllBytes();
				System.out.println("in Servlet");
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}

		
		
		MyFriendsPostModel myfriendspostmodel=new MyFriendsPostModel();
		if(Title!=null && Category!=null && Description!=null && Location!=null && imagebyte!=null)
		{	
			System.out.println("done");
			myfriendspostmodel.setTitle(Title);
			myfriendspostmodel.setCategory(Category);
			myfriendspostmodel.setDescription(Description);
	        myfriendspostmodel.setLocation(Location);
			myfriendspostmodel.setImage(imagebyte);
			myfriendspost.save(myfriendspostmodel);
		}
		doGet(request, response);
	}

}