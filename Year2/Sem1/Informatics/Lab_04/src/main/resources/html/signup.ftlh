<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign up</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <form name="signupForm" method="post" action="/Lab_04_war/signup">
        Username: <input type="text" name="username"/> <br/>
        Email: <input type="text" name="email"/> <br/>
        First name: <input type="text"  name="firstname"/> <br/>
        Last name: <input type="text" name="lastname"/> <br/>
        Password: <input type="password" name="password"/> <br/>
        Password Confirmation: <input type="password" name="password_confirmation"/> <br/>
        <input type="submit" value="Sign up"/>
    </form>
</body>
</html>