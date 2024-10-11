<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: eugen--%>
<%--  Date: 10/9/2024--%>
<%--  Time: 8:35 PM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <title>MoneyTracker - Dashboard</title>--%>
<%--    <style>--%>
<%--        body {--%>
<%--            font-family: Arial, sans-serif;--%>
<%--            background-color: #f4f4f4;--%>
<%--            margin: 0;--%>
<%--            padding: 0;--%>
<%--            display: flex;--%>
<%--            justify-content: center;--%>
<%--            align-items: flex-start;--%>
<%--            height: 100vh;--%>
<%--        }--%>
<%--        .dashboard-container {--%>
<%--            background-color: white;--%>
<%--            padding: 2rem;--%>
<%--            border-radius: 8px;--%>
<%--            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);--%>
<%--            width: 500px;--%>
<%--            margin-top: 2rem;--%>
<%--        }--%>
<%--        h1 {--%>
<%--            text-align: center;--%>
<%--            color: #333;--%>
<%--            margin-bottom: 1.5rem;--%>
<%--        }--%>
<%--        .balance {--%>
<%--            font-size: 1.5rem;--%>
<%--            font-weight: bold;--%>
<%--        }--%>
<%--        .positive {--%>
<%--            color: green;--%>
<%--        }--%>
<%--        .negative {--%>
<%--            color: red;--%>
<%--        }--%>
<%--        .user-info {--%>
<%--            text-align: center;--%>
<%--            margin-bottom: 2rem;--%>
<%--        }--%>
<%--        .user-info h2 {--%>
<%--            margin: 0;--%>
<%--            font-size: 1.5rem;--%>
<%--        }--%>
<%--        .user-info p {--%>
<%--            font-size: 1rem;--%>
<%--            color: #666;--%>
<%--        }--%>
<%--        .finance-report {--%>
<%--            margin-bottom: 2rem;--%>
<%--        }--%>
<%--        .finance-report table {--%>
<%--            width: 100%;--%>
<%--            border-collapse: collapse;--%>
<%--        }--%>
<%--        .finance-report table th, .finance-report table td {--%>
<%--            border-bottom: 1px solid #ddd;--%>
<%--            padding: 0.75rem;--%>
<%--            text-align: left;--%>
<%--        }--%>
<%--        .finance-report table th {--%>
<%--            background-color: #f4f4f4;--%>
<%--        }--%>
<%--        .finance-report table td {--%>
<%--            font-size: 1.1rem;--%>
<%--        }--%>
<%--        .actions {--%>
<%--            text-align: center;--%>
<%--        }--%>
<%--        button, a {--%>
<%--            background-color: #4CAF50;--%>
<%--            color: white;--%>
<%--            padding: 0.75rem 1.5rem;--%>
<%--            border: none;--%>
<%--            border-radius: 4px;--%>
<%--            font-size: 1rem;--%>
<%--            cursor: pointer;--%>
<%--            text-decoration: none;--%>
<%--            transition: background-color 0.3s;--%>
<%--        }--%>
<%--        button:hover, a:hover {--%>
<%--            background-color: #45a049;--%>
<%--        }--%>
<%--        .logout {--%>
<%--            background-color: #787777;--%>
<%--        }--%>
<%--        .logout:hover {--%>
<%--            background-color: #ea7c79;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="dashboard-container">--%>
<%--    <h1>Welcome to MoneyTracker</h1>--%>

<%--    <div class="user-info">--%>
<%--        <h2>Hello, <c:out value="${userName}" /></h2>--%>
<%--        <p>Today's date: <c:out value="${currentDate}" /></p>--%>
<%--    </div>--%>

<%--    <div class="finance-report">--%>
<%--        <h3>Finance Report</h3>--%>
<%--        <table>--%>
<%--            <tr>--%>
<%--                <th>Income (Since Start of Month)</th>--%>
<%--                <td><c:out value="${income}" /> USD</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>Expense (Since Start of Month)</th>--%>
<%--                <td><c:out value="${expense}" /> USD</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>Current Balance</th>--%>
<%--                <td><c:out value="${balance}" /> USD</td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </div>--%>

<%--    <div class="actions">--%>
<%--        <button onclick="location.href='addTransaction.jsp'">Add Transaction</button>--%>
<%--        <a class="logout" href="controller?command=logout">Logout</a>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MoneyTracker - Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .dashboard-container {
            background-color: white;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            margin: 50px auto;
            text-align: center;
        }
        h1 {
            color: #333;
        }
        .balance {
            font-size: 1.5rem;
            font-weight: bold;
        }
        .positive {
            color: green;
        }
        .negative {
            color: red;
        }
        .report {
            margin: 1rem 0;
        }
        .date {
            font-size: 0.9rem;
            color: #666;
            margin-bottom: 1.5rem;
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
        a {
            color: #4c59af;
            text-decoration: none;
            margin-top: 1.5rem;
            display: inline-block;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="dashboard-container">
    <h1>Welcome, ${userName}!</h1>
    <div class="date">${currentDate}</div>

    <div class="report">
        <p>Income (since the beginning of the month): $${income}</p>
        <p>Expense (since the beginning of the month): $${expense}</p>
    </div>

    <!-- Conditionally display balance in green or red -->
    <div class="balance">
        <c:choose>
            <c:when test="${balance >= 0}">
                <span class="positive">Current Balance: $${balance}</span>
            </c:when>
            <c:otherwise>
                <span class="negative">Current Balance: $${balance}</span>
            </c:otherwise>
        </c:choose>
    </div>

    <br/><br/>

    <button onclick="location.href='addTransaction.jsp'">Add Transaction</button>
    <br/><br/>
    <a class="logout" href="controller?command=logout">Logout</a>
</div>
</body>
</html>
