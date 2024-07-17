<%@page import="com.iss.services.MyPosts" %>
<%@page import="com.iss.services.IMyPosts" %>
<%@page import="java.util.*" %>
<%@page import="com.iss.models.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MYPOSTS</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
    <jsp:include page="Include.jsp" />
	
    <%-- Initialize the object in a scriptlet --%>
    <%
    	String username = (String) session.getAttribute("user");
    	System.out.println("display"+username);
    	if (username != null) {
	        IMyPosts postsService = new MyPosts();
	        List<MyPostsModel> posts = postsService.getAllPostsByUserName(username);
	        pageContext.setAttribute("posts",posts); // Set the posts as a request attribute
    	}
    %>
     
<div class="carousel-inner py-4">
    	<!-- Single item -->
    	<form action="/MyPosts/MyPosts.jsp" method="post">
        	<button type="submit" class="btn btn-dark ">New Post</button>
         </form>
    <div class="carousel-item active">
      <div class="container mt-4 style="max-width: 800px;">
        <div class="row">
    		<c:forEach var="mpost" items="${posts}">
	          <div class="col-sm-6 col-md-4">
	            <div class="card">
	              <img
	                src='/MyPosts/GetImageForPost?id=${mpost.id}'
	                style="max-width: 100%; height: auto; max-height: 200px;"
	              />
	              <div class="card-body">
	                <h5 class="card-title">Card title</h5>
	                <p class="card-text" style="margin-bottom: 5px;"><c:out value="${mpost.id}" /></p>
					<p class="card-text" style="margin-bottom: 5px;"><c:out value="${mpost.title}" /></p>
				   	<p class="card-text" style="margin-bottom: 5px;"><c:out value="${mpost.category}" /></p>
				    <p class="card-text" style="margin-bottom: 5px;"><c:out value="${mpost.description}" /></p>
				    <p class="card-text" style="margin-bottom: 5px;"><c:out value="${mpost.location}" /></p>
				    <p class="card-text" style="margin-bottom: 5px;"><c:out value="${mpost.createdBy}" /></p>
				    <p class="card-text" style="margin-bottom: 5px;"><c:out value="${mpost.createdDate}" /></p>
				    
	                <form action="/MyPosts/MyPst" method="post" enctype="multipart/form-data">

					    <input type="hidden" name="postId" value="${mpost.id}">
					    <input type="hidden" name="status" value="Active">
					    <button type="submit" name="submitBtn" style="background-color:MediumSeaGreen;" class="btn btn-primary">Active</button>
					</form>
        			<form action="/MyPosts/MyPst" method="post" enctype="multipart/form-data">

					    <input type="hidden" name="postId" value="${mpost.id}">
					    <input type="hidden" name="status" value="Inactive">
					    <button type="submit" name="submitBtn" style="background-color:Tomato;" class="btn btn-secondary">Inactive</button>
					</form>
					</div>
	            </div>
	          </div>
	          </c:forEach>
	         </div>
	        </div>
	      </div>
	     </div>
    
	
        
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
