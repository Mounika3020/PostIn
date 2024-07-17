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

public class MyPostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Integer Id;
	String Title;
	String Category;
	String Description;
	String Location;
	String CreatedBy;
	String CreatedDate;
	String Status;
	byte[] imagebyte = null;
    public MyPostsServlet() { 	
    	
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyPosts mypost=new MyPosts();
		MultipartRequest multipartrequest = new MultipartRequest(request,getServletContext().getRealPath(""));
		try {
			System.out.println("hello"+getServletContext().getRealPath(""));
			
			
			if(multipartrequest.getParameter("ID")!=null)
			{
				Id=Integer.parseInt(multipartrequest.getParameter("ID"));
				Title=multipartrequest.getParameter("Title");
				Category=multipartrequest.getParameter("Category");
				Description=multipartrequest.getParameter("Description");
				File file=multipartrequest.getFile("image");
				File copiedfile=new File(getServletContext().getRealPath("")+"//"+file.getName());
				FileInputStream fileinputstream=new FileInputStream(copiedfile);
				imagebyte=fileinputstream.readAllBytes();
				Location=multipartrequest.getParameter("Location");
				CreatedBy=multipartrequest.getParameter("Created By");
				CreatedDate=multipartrequest.getParameter("Created Date");
				Status=multipartrequest.getParameter("Status");
			}
		}catch(Exception ex) {
			System.out.println("Exception");
			 ex.printStackTrace();
		}
		System.out.println("in Servlet");
		MyPostsModel mypostmodel=new MyPostsModel();
		if(Id!=null && Title!=null && Category!=null && Description!=null && imagebyte!=null && Location!=null && CreatedBy!=null && CreatedDate!=null )
		{		
			mypostmodel.setId(Id);
			mypostmodel.setTitle(Title);
			mypostmodel.setCategory(Category);
			mypostmodel.setDescription(Description);
			mypostmodel.setImage(imagebyte);
			mypostmodel.setLocation(Location);
			mypostmodel.setCreatedBy(CreatedBy);
			mypostmodel.setCreatedDate(CreatedDate);
			mypostmodel.setStatus(Status);
			mypost.save(mypostmodel);
			System.out.println("done");
		}	
		int Idno = 0;
		if(multipartrequest.getParameter("postId")!=null)
		{	
			Idno = Integer.parseInt(multipartrequest.getParameter("postId"));
		}
	    String Status = multipartrequest.getParameter("status");
	    System.out.println("my post"+Idno);
	    if (Idno !=0&&Status!=null) {
	    	mypost.update(Idno, Status);
        
	    } else {
        
	    	System.out.println("error");
	    }
	    doGet(request, response);
	}
}

