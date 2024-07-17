
<%@ page import="com.iss.services.MyMessage" %>
<%@ page import="com.iss.services.IMyMessage" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iss.models.MyMessageModel" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>message</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <style>
* {box-sizing: border-box;}

body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #e9e9e9;
}

.topnav a {
  float: left;
  display: block;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #2196F3;
  color: white;
}


}
</style>
</head>
<body>
    <jsp:include page="Include.jsp" />
    <%
	    try {
	    	String username = (String) session.getAttribute("user");
	    	System.out.println("message 2"+username);
	    	if (username != null) {
		        IMyMessage messageService = new MyMessage();
		        List<MyMessageModel> messages = messageService.getAllMessagesByUserName(username);
		        pageContext.setAttribute("messages", messages);
	    	}
	    } catch (Exception e) {
	        // Handle the exception (e.g., log it or display an error message)
	        e.printStackTrace();
	    }
  
    %>
     
<div class="carousel-inner py-4">
    <!-- Single item -->
    <div class="carousel-item active">
    <h1>Recived Messages</h1>
        <div class="container mt-4" style="max-width: 800px;">
        
            <div class="row">
                <c:forEach var="message" items="${messages}">
                    <div class="col-sm-6 col-md-4">
                        <div class="topnav">
              
			 				 <a class="active" ><p class="card-text" style="margin-bottom: 5px;"><c:out value="${message.frm}" /></p></a>
			  				 <a > <p class="card-text" style="margin-bottom: 5px;"><c:out value="${message.message}" /></p></a>
			  			
			  			</div>      
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
		<%
		try {
		    String username = (String) session.getAttribute("user");
		    System.out.println("message"+username);
		    if (username != null) {
		        IMyMessage messageService = new MyMessage();
		        List<MyMessageModel> sentMessages = messageService.getAllSentMessagesByUserName(username);
		        pageContext.setAttribute("sentMessages", sentMessages);
		    }
		} catch (Exception e) {
		    // Handle the exception (e.g., log it or display an error message)
		    e.printStackTrace();
		}
		%>

<div class="carousel-inner py-4">
    <!-- Single item -->
    <div class="carousel-item active">
        <h1>Sent Messages</h1>
        <div class="container mt-4" style="max-width: 800px;">
            <div class="row">
                <c:forEach var="sentMessage" items="${sentMessages}">
                    <div class="col-sm-6 col-md-4">
                        <div class="topnav">
                            <a class="active" >
                                <p class="card-text" style="margin-bottom: 5px;"><c:out value="${sentMessage.too}" /></p>
                            </a>
                            <a >
                                <p class="card-text" style="margin-bottom: 5px;"><c:out value="${sentMessage.message}" /></p>
                            </a>
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
