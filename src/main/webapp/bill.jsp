<%@ page import="com.hotel.model.Payment" %>
<%@ page import="com.hotel.model.Booking" %>

<%
    Payment payment = (Payment) request.getAttribute("payment");
    Booking booking = (Booking) request.getAttribute("booking");
%>

<html>
<head>
    <title>Hotel Bill</title>
</head>
<body>

<h2>Hotel Bill</h2>

<%
    if (payment != null && booking != null) {
%>

<table border="1" cellpadding="10">
    <tr>
        <th>Payment ID</th>
        <td><%= payment.getPaymentId() %></td>
    </tr>
    <tr>
        <th>Booking ID</th>
        <td><%= payment.getBookingId() %></td>
    </tr>
    <tr>
        <th>Customer Name</th>
        <td><%= booking.getCustomerName() %></td>
    </tr>
    <tr>
        <th>Room Number</th>
        <td><%= booking.getRoomNumber() %></td>
    </tr>
    <tr>
        <th>Check In Date</th>
        <td><%= booking.getCheckInDate() %></td>
    </tr>
    <tr>
        <th>Check Out Date</th>
        <td><%= booking.getCheckOutDate() %></td>
    </tr>
    <tr>
        <th>No. of Days</th>
        <td><%= booking.getNoOfDays() %></td>
    </tr>
    <tr>
        <th>Total Amount</th>
        <td>Rs <%= payment.getAmount() %></td>
    </tr>
    <tr>
        <th>Payment Date</th>
        <td><%= payment.getPaymentDate() %></td>
    </tr>
    <tr>
        <th>Payment Method</th>
        <td><%= payment.getPaymentMethod() %></td>
    </tr>
    <tr>
        <th>Payment Status</th>
        <td><%= payment.getPaymentStatus() %></td>
    </tr>
</table>

<%
} else {
%>
<p>No bill data found.</p>
<%
    }
%>

<br>
<a href="dashboard.jsp">Back to Dashboard</a>

</body>
</html>