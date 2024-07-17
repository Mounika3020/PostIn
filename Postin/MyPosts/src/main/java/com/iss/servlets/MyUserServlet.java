package com.iss.servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.iss.models.*;
import com.iss.services.*;

public class MyUserServlet extends HttpServlet {
	String FirstName;
	String LastName;
	String Email;
	String Location;
	String Password;
	String ConfirmPassword;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUser myuser=new MyUser();
		System.out.println(request.getParameter("FirstName"));
		if(request.getParameter("FirstName")!=null)
		{
			FirstName=request.getParameter("FirstName");
			LastName=request.getParameter("LastName");
			Email=request.getParameter("Email");
			Location=request.getParameter("Location");
			Password=request.getParameter("Password");
			ConfirmPassword=request.getParameter("ConfirmPassword");
		}
		MyUserModel myusermodel=new MyUserModel();
		if(FirstName!=null && LastName!=null && Email!=null && Location!=null && Password!=null && ConfirmPassword!=null)
		{
			myusermodel.setFirstName(FirstName);
			myusermodel.setLastName(LastName);
			myusermodel.setEmail(Email);
			myusermodel.setLocation(Location);
			myusermodel.setPassword(Password);
			myusermodel.setConfirmPassword(ConfirmPassword);
			
			myuser.save(myusermodel);
			System.out.println("done");
		}
		doGet(request, response);
	}

}