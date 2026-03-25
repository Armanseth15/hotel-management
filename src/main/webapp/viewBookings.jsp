<%@ page import="java.util.List" %>
<%@ page import="com.hotel.model.Booking" %>
<%
    List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");
%>
<html>
<head>
    <title>View Bookings</title>
</head>
<body>
<h2>All Bookings</h2>

<table border="1" cellpadding="10">
    <tr>
        <th>Booking ID</th>
        <th>Customer Name</th>
        <th>Room Number</th>
        <th>Check In</th>
        <th>Check Out</th>
        <th>No. of Days</th>
        <th>Total Amount</th>
        <th>Status</th>
    </tr>

    <%
        if (bookings != null) {
            for (Booking b : bookings) {
    %>
    <tr>
        <td><%= b.getBookingId() %></td>
        <td><%= b.getCustomerName() %></td>
        <td><%= b.getRoomNumber() %></td>
        <td><%= b.getCheckInDate() %></td>
        <td><%= b.getCheckOutDate() %></td>
        <td><%= b.getNoOfDays() %></td>
        <td><%= b.getTotalAmount() %></td>
        <td><%= b.getBookingStatus() %></td>
    </tr>
    <%
            }
        }
    %>
</table>

<br>
<a href="dashboard.jsp">Back to Dashboard</a>
</body>
</html>