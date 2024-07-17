package com.iss.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iss.models.MyFriendsModel;
import com.iss.models.MyUserModel;
import com.iss.services.IMyUser;
import com.iss.services.MyFriends;
import com.iss.services.MyUser;

public class MyFriendsServlet extends HttpServlet {
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String friendId = request.getParameter("FriendID");
        String userId = request.getParameter("UserID");
        String status = "pending";
        MyFriends myfriends = new MyFriends();
        HttpSession s = request.getSession();
        String username = (String) s.getAttribute("user");
        
        IMyUser myUserService = new MyUser();
        MyFriendsModel myfriendsmodel = new MyFriendsModel();
        List<MyUserModel> user = myUserService.getbyFriendid(friendId);
        
        if (user != null) {
            System.out.println(user);
            System.out.println(friendId);

            myfriendsmodel.setFriendId(friendId);
            myfriendsmodel.setUserId(userId);
            myfriendsmodel.setStatus(status);
            
            System.out.println("Friend request saved");
        }
        
        String updateUserId = request.getParameter("userid");
        String updateStatus = request.getParameter("status");
        System.out.println(updateStatus);
        if (updateUserId != null && updateStatus != null) {
            myfriends.update(updateUserId, updateStatus,username);
        } else {
            myfriends.save(myfriendsmodel);
        }

    }
}
