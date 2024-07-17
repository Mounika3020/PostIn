<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <div class="row ">
            <div class="col-md-5">
                <form action="/MyPosts/MyUS" method="post">
                <h1 class="mb-4">User Registration</h1>
                    <div class="form-group">
                        <label for="First Name">First Name</label>
                        <input type="text" class="form-control" id="FirstName" name="FirstName" required>
                    </div>
                    <div class="form-group">
                        <label for="Last Name">Last Name</label>
                        <input type="text" class="form-control" id="LastName" name="LastName" required>
                    </div>
                    <div class="form-group">
                        <label for="Email">Email</label>
                        <input type="text" class="form-control" id="Email" name="Email" required>
                    </div>
                    <div class="form-group">
                        <label for="Location">Location</label>
                        <input type="text" class="form-control" id="Location" name="Location" required>
                    </div>
                    <div class="form-group">
                        <label for="Password">Password</label>
                        <input type="text" class="form-control" id="Password" name="Password" required>
                    </div>
                    <div class="form-group">
                        <label for="Confirm Password">Confirm Password</label>
                        <input type="text" class="form-control" id="ConfirmPassword" name="ConfirmPassword" required>
                    </div>
                    </div>
                	
               		  <button type="submit" class="btn btn-primary btn-block">Register</button>
               		</form>
            </div>
           </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>