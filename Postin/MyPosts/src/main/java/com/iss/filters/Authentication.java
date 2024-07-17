package com.iss.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpSession;

import com.iss.models.MyUserModel;
import com.iss.services.IMyUser;
import com.iss.services.MyUser;
import javax.servlet.http.HttpServletRequest;

public class Authentication extends HttpFilter implements Filter {

    public void destroy() {
        // TODO Auto-generated method stub
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        try {
            IMyUser myUserService = new MyUser();
            MyUserModel user = myUserService.findByEmail(username);

            if (user != null && user.getPassword().equals(password)) {
            	HttpSession session=((HttpServletRequest)request).getSession(true);
            	session.setAttribute("user", user.getEmail());
            	System.out.println(user.getEmail());
                RequestDispatcher rd = request.getRequestDispatcher("Dashboard.jsp");
                rd.forward(request, response);
            } else {
                out.print("Sorry UserName or Password Error!");
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.include(request, response);
                return; // Stop processing the filter chain
            }
        } catch (Exception ex) {
            out.print(ex);
        }
        chain.doFilter(request, response); // Continue with the filter chain
    }

    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
