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
    <title>MYFRIENDS</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
    <jsp:include page="Include.jsp" />

    <%
    	HttpSession s = request.getSession();
    	String username = (String) s.getAttribute("user");
        IMyFriends friendsService = new MyFriends();
        List<MyFriendsModel> friends = friendsService.getAll(username);
        pageContext.setAttribute("friends",friends);
    %>

    
        
        <table class="table mt-4">
            <thead>
                <tr>
                    <th>Friend-ID</th>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach var="mfriends" items="${friends}">
                    <tr>
                        <td><c:out value="${mfriends.getFriendId()}" /></td>
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
 
		<div class="container mt-4">
		    <div class="d-flex">
		        <form action="/MyPosts/MyFriends.jsp" method="post" class="mr-2">
		            <button type="submit" class="btn btn-dark">Add Friend</button>
		        </form>
		        <form action="/MyPosts/ViewSentRequest.jsp" method="post" class="mr-2">
		            <button type="submit" class="btn btn-dark">Sent Requests</button>
		        </form>
		        <form action="/MyPosts/ViewFriendRequest.jsp" method="post">
		            <button type="submit" class="btn btn-dark">Friend Requests</button>
		        </form>
		    </div>
		</div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
