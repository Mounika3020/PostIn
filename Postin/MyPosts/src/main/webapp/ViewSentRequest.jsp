<%@page import="com.iss.services.MyFriends" %>
<%@page import="com.iss.services.IMyFriends" %>
<%@page import="java.util.*" %>
<%@page import="com.iss.models.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Sent Request</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
  <jsp:include page="Include.jsp" />
             
    <%
    	HttpSession s = request.getSession();
		String username = (String) s.getAttribute("user");
		System.out.println(username);
        IMyFriends friendsService = new MyFriends();
        List<MyFriendsModel> friend = friendsService.getFriendsById(username);
        pageContext.setAttribute("friend",friend); // Set the posts as a request attribute
    %>

    
        
        <table class="table mt-4">
            <thead>
                <tr>
                    <th>Friend-ID</th>
                     <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="mfriend" items="${friend}">
                    <tr>
                        <td><c:out value="${mfriend.getFriendId()}" /></td>
                        <td><c:out value="${mfriend.getStatus()}" /></td>
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
 
                

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>