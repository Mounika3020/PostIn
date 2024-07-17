<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.security.Principal" %>
<html>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <title>My Messages</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    </head>
    <%
// Get the current session
	HttpSession s = request.getSession();

	String username = (String) s.getAttribute("user");
%>
    <body>
        <jsp:include page="Include.jsp" />
        <div class="container">
            <h2>My Messages</h2>
            <form action="/MyPosts/MyMessage" method="post">
                <div class="form-group">
                    <label for="From">From</label>
                    <input type="text" class="form-control" id="From"  name="From" value="<%= username %>">
                </div>
                <div class="form-group">
                    <label for="To">To</label>
                    <input type="text" class="form-control" id="To"  name="To" >
                </div>
                <div class="form-group">
                    <label for="Message">Message</label>
                    <input type="text" class="form-control" id="Message"  name="Message">
                </div>
                <button type="submit" class="btn btn-primary btn-block mt-3">Send</button>
            </form>
        </div>



            
    </body>
</html>