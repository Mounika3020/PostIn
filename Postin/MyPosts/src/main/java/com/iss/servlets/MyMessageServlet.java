package com.iss.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.iss.models.*;
import com.iss.services.*;

public class MyMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MyMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    MyMessage mymsg = new MyMessage();
	    String from = request.getParameter("From");
	    String messageContent = request.getParameter("Message"); // Renamed to avoid conflicts with reserved keyword 'message'
	    String to = request.getParameter("To");
	    System.out.println("in Servlet");
	    
	    MyMessageModel mymsgmodel = new MyMessageModel();
	    mymsgmodel.setFrm(from);
	    mymsgmodel.setMessage(messageContent);
	    mymsgmodel.setToo(to);
	    
	    mymsg.save(mymsgmodel);
	    
	    // Add mymsgmodel as an attribute to the request
	    request.setAttribute("message", mymsgmodel);
	    
	    // Forward the request to message.jsp
	    request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	}
