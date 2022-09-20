<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
        Welcome to your profile <br>
        First name:
        <text>${firstname!}</text>
        <br>
        Last name:
        <text>${lastname!}</text>
        <br>
        <form name="logout" method="get" action="/Lab_04_war/logout">
            <label>
                <input type="submit" value="log out">
            </label>
        </form>
</body>
</html>
