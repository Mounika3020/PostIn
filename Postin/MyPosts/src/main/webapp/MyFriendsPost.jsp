<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Friends Posts</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
    <jsp:include page="Include.jsp" />
    <div class="container mt-5">
        <div class="row ">
            <div class="col-md-5">
                
                <h1 class="mb-4">MY FRIENDS POSTS</h1>
                <form action="/MyPosts/MyFPS" method="post" enctype="multipart/form-data">
                    
                    <div class="form-group">
                        <label for="Title">Title</label>
                        <input type="text" class="form-control" id="Title" name="Title" required>
                    </div>
                    <div class="form-group">
                        <label for="Category">Category (pet,mobile,Two wheeler,Furniture)</label>
                        <input type="text" class="form-control" id="Category" name="Category" required>
                    </div>
                    <div class="form-group">
                        <label for="Description">Description</label>
                        <input type="text" class="form-control" id="Description" name="Description" required>
                    </div>
                    <div class="form-group">
                        <label for="Location">Location</label>
                        <input type="text" class="form-control" id="Location" name="Location" required>
                    </div>
                    <div class="form-group">
                        <label for="imageInput">Select an image</label>
                        <input type="file" id="imageInput" accept="image/*" name="image">
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">POST</button>
                </form>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>