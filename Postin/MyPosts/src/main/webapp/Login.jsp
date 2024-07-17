<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
  <style>
    h1 {
        font-family: Arial, Helvetica, sans-serif;
        font-size: 40px;
    }
  </style>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-white navbar-white">
    <div class="container-fluid mt-3">
        <h1>Post Out</h1>
        <form action="/MyPosts/User.jsp" method="POST">
            <button type="submit" class="btn btn-dark">Sign up</button>
        </form>
    </div>   
</nav>

<div class="container mt-5">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title">Login</h2>
                    <form action="/MyPosts/Login" method="POST">
                        <div class="form-group">
                            <label for="username">Username/Email</label>
                            <input type="text" class="form-control" id="username" name="username"
                                placeholder="Enter Username/Email">
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" name="password"
                                placeholder="Enter Password">
                        </div>
                        <button type="submit" class="btn btn-primary">LOG IN</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%
    // Retrieve username from the request parameter
    String username = request.getParameter("username");
    
    // If username is not null or empty, save it in the session
    HttpSession s;
    System.out.println("login"+username);
    if (username != null && !username.isEmpty()) {
        s= request.getSession();
        s.setAttribute("username", username);
        
    }
%>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</body>
</html>
