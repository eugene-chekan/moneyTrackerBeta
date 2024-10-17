<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 10/12/2024
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MoneyTracker - Signup Successful</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .success-container {
            background-color: white;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 500px;
        }
        h1 {
            color: #4CAF50;
            margin-bottom: 1.5rem;
        }
        p {
            color: #333;
            margin-bottom: 1.5rem;
        }
        a {
            text-decoration: none;
            color: #4CAF50;
            font-weight: bold;
        }
        a:hover {
            text-decoration: underline;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 0.75rem;
            border: none;
            border-radius: 4px;
            font-size: 1rem;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="success-container">
    <h1>Sign Up Successful!</h1>
    <h3>Nice to meet you ${firstName}!</h3>
    <p>Your account has been created successfully.</p>
    <p>You can now log in with your new credentials.</p>
    <a href="${pageContext.request.contextPath}/index.jsp">Go to Login Page</a>
</div>
</body>
</html>

