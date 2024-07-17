package com.iss.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStream;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.iss.services.MyPosts;
import com.iss.services.IMyPosts;
import com.iss.models.*;

public class GetImageForPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetImageForPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IMyPosts		postsService=new MyPosts();
		
		OutputStream out=response.getOutputStream();
		
		
		if(request.getParameter("id")!=null)
		{
			int id=Integer.parseInt(request.getParameter("id"));
			MyPostsModel 	post=postsService.getPostById(id);
			byte[] bytes=post.getImage();
			System.out.println(bytes.length);
			response.setContentType("image/jpeg");
			//response.setHeader("Content-Disposition","attachment; filename=download.jpg");
			out.write(bytes);
		}
        
	}
}
