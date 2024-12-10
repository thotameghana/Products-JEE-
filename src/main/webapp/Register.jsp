<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: skyblue;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    form {
        background: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        width: 350px;
        text-align: center;
    }
    h2 {
        color: #333;
    }
    input[type="text"], input[type="email"], input[type="password"] {
        width: 90%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 14px;
    }
    input[type="submit"], button {
        width: 100%;
        padding: 10px;
        margin-top: 10px;
        background-color: #5cb85c;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 14px;
    }
    input[type="submit"]:hover {
        background-color: #4cae4c;
    }
    button {
        background-color: #337ab7;
    }
    button:hover {
        background-color: #286090;
    }
    button a {
        text-decoration: none;
        color: white;
        display: block;
    }
</style>
</head>
<body>
    <form action="Register" method="post">
        <h2>Register</h2>
        <input type="text" name="username" placeholder="Enter your username"><br>
        <input type="email" name="email" placeholder="Enter your email"><br>
        <input type="password" name="password" placeholder="Enter your password"><br>
        <input type="password" name="cpassword" placeholder="Confirm your password"><br>
        <input type="text" name="address" placeholder="Enter your address"><br>
        <input type="submit" value="Register">
        <button><a href="login.jsp">Login</a></button>
    </form>
</body>
</html>
