<html>
	<head>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
		<title>Login Page</title>
	</head>
	<body>
		<div class="container">
			<h2>
				<h1>Login Page</h1>
				<div>
					<pre>error Message: ${Error}</pre>
				</div>
				<div>
					<form action="login" method="post">
					    Name: <input type="text" name="name">
					    Password: <input type="password" name="password">
					    <input type="submit" value="Login">
					</form>
				</div>
			</h2>
		</div>
	</body>
</html>