<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    HttpSession s = request.getSession(false);
    if (s == null || s.getAttribute("admin") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<html>
<head>
    <title>Add Room</title>
</head>
<body>
<h2>Add Room</h2>

<form action="addRoom" method="post">
    Room Number: <input type="text" name="roomNumber" required><br><br>
    Room Type:
    <select name="roomType">
        <option>Single</option>
        <option>Double</option>
        <option>Deluxe</option>
    </select><br><br>
    Price: <input type="number" step="0.01" name="price" required><br><br>
    Status:
    <select name="status">
        <option>Available</option>
        <option>Booked</option>
    </select><br><br>
    <input type="submit" value="Add Room">
</form>

<br>
<a href="dashboard.jsp">Back to Dashboard</a>
</body>
</html>