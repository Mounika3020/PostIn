<%@ page import="com.iss.services.MyFriends" %>
<%@ page import="com.iss.services.IMyFriends" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iss.models.MyFriendsModel" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Friend Request</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="Include.jsp" />
             
<%
    HttpSession s = request.getSession();
    String username = (String) s.getAttribute("user");
    System.out.println(username + "hello");
    IMyFriends friendsService = new MyFriends();
    List<MyFriendsModel> friendList = friendsService.getRequestById(username);
   	System.out.println(friendList.size());
    request.setAttribute("myfriend", friendList); // Set the friend list as a request attribute
%>

<table class="table mt-4">
    <thead>
        <tr>
            <th>Friend-ID</th>
            <th>Status</th>

        </tr>
    </thead>
    <tbody>
        <c:forEach var="friend" items="${myfriend}">
            <tr>
            	<c:out value = "${friend.userId}"/>
                <td>${friend.userId}</td>
                <td>
                    <form action="<%= request.getContextPath() %>/MyFS" method="post">
                        <input type="hidden" name="userid" value="${friend.userId}">
                        <input type="hidden" name="status" value="accept">
                        <button type="submit" style="background-color:MediumSeaGreen;" class="btn btn-primary">accept</button>
                    </form>
                    <form action="<%= request.getContextPath() %>/MyFS" method="post">
                        <input type="hidden" name="userid" value="${friend.userId}">
                        <input type="hidden" name="status" value="block">
                        <button type="submit" style="background-color:Tomato;" class="btn btn-secondary">block</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
