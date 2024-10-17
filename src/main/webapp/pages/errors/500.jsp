<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 10/13/2024
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Server Error - 500</title>
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
        .error-container {
            text-align: center;
            background-color: white;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 4600px;
        }
        h1 {
            font-size: 48px;
            color: #FF6347;
            margin-bottom: 1rem;
        }
        p {
            font-size: 18px;
            color: #333;
            margin-bottom: 1.5rem;
        }
        a {
            color: #4CAF50;
            text-decoration: none;
            font-size: 16px;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="error-container">
    <h1>500</h1>
    <p>Something went wrong on our end. Please try again later.</p>
    <p><a href="${pageContext.request.contextPath}/index.jsp">Go to Home</a></p>
</div>
</body>
</html>
