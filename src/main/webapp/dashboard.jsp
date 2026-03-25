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
    <title>Dashboard</title>
</head>
<body>
<h2>Welcome, <%= s.getAttribute("admin") %></h2>

<ul>
    <li><a href="addRoom.jsp">Add Room</a></li>
    <li><a href="viewRooms">View Rooms</a></li>
    <li><a href="addCustomer.jsp">Add Customer</a></li>
    <li><a href="bookRoom.jsp">Book Room</a></li>
    <li><a href="viewBookings">View Bookings</a></li>
    <li><a href="logout">Logout</a></li>
</ul>
</body>
</html>