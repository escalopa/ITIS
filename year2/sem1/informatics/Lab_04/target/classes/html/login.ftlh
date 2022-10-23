<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Log In</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<form name="loginForm" method="post" action="/Lab_04_war/login">
    Username: <input type="text" name="username"/> <br/>
    Password: <input type="password" name="password"/> <br/>
    <input type="submit" value="Login"/>
</form>
<h3>Don't have account? Sign up now</h3>
<form name="loginForm" method="get" action="/Lab_04_war/signup">
    <input type="submit" value="Sign Up"/>
</form>

</body>
</html>