<%@ page import="java.util.List" %>
<%@ page import="com.hotel.model.Room" %>
<%
    List<Room> rooms = (List<Room>) request.getAttribute("rooms");
%>
<html>
<head>
    <title>View Rooms</title>
</head>
<body>
<h2>All Rooms</h2>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Room Number</th>
        <th>Room Type</th>
        <th>Price</th>
        <th>Status</th>
    </tr>
    <%
        if (rooms != null) {
            for (Room r : rooms) {
    %>
    <tr>
        <td><%= r.getRoomId() %></td>
        <td><%= r.getRoomNumber() %></td>
        <td><%= r.getRoomType() %></td>
        <td><%= r.getPrice() %></td>
        <td><%= r.getStatus() %></td>
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