<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add / Edit Book</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>${book.id == 0 ? "Add New Book" : "Edit Book"}</h2>

    <form action="${book.id == 0 ? '/save' : '/update'}" method="post">
        <input type="hidden" name="id" value="${book.id}"/>

        <div class="mb-3">
            <label>Title</label>
            <input type="text" name="title" value="${book.title}" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Author</label>
            <input type="text" name="author" value="${book.author}" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>ISBN</label>
            <input type="text" name="isbn" value="${book.isbn}" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-success">${book.id == 0 ? "Save" : "Update"}</button>
    </form>
</div>
</body>
</html>

