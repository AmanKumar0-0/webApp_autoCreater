
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5 text-center">
    <h1>Welcome!</h1>
    <p>Choose the module you want to access:</p>

    <div class="d-flex justify-content-center gap-3 mt-4">
        <!-- Button for Todo Management -->
        <form action="/list-todos" method="get">
            <button type="submit" class="btn btn-primary btn-lg">Todo Management</button>
        </form>

        <!-- Button for Library Management -->
        <form action="/library_index" method="get">
            <button type="submit" class="btn btn-success btn-lg">Library Management</button>
        </form>
    </div>
</div>
</body>
</html>
