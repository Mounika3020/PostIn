<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Friends</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
  <jsp:include page="Include.jsp" />
    <div class="container mt-5">
        <div class="row ">
            <div class="col-md-5">
             <%
			// Get the current session
				HttpSession s = request.getSession();
			
				String username = (String) s.getAttribute("user");
			%>
                
                <h1 class="mb-4">MY FRIENDS</h1>
                <form action="/MyPosts/MyFS" method="post">
                    <div class="form-group">
                        <label for="UserID1">UserID</label>
                        <input type="text" class="form-control" id="UserID" name="UserID" value="<%= username %>" required>
                    </div>
                    <div class="form-group">
                        <label for="FriendID">FriendID</label>
                        <input type="text" class="form-control" id="FriendID" name="FriendID" required>
                    </div>
                   
                    
                <button type="submit" class="btn btn-primary btn-block">Add</button>
                </form>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>