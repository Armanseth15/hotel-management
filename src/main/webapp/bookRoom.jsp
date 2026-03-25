<%@ page import="java.util.List" %>
<%@ page import="com.hotel.dao.CustomerDAO" %>
<%@ page import="com.hotel.dao.RoomDAO" %>
<%@ page import="com.hotel.model.Customer" %>
<%@ page import="com.hotel.model.Room" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<%
    HttpSession s = request.getSession(false);
    if (s == null || s.getAttribute("admin") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    CustomerDAO customerDAO = new CustomerDAO();
    RoomDAO roomDAO = new RoomDAO();

    List<Customer> customers = customerDAO.getAllCustomers();
    List<Room> rooms = roomDAO.getAvailableRooms();
%>

<html>
<head>
    <title>Book Room</title>
</head>
<body>
<h2>Book Room</h2>

<form action="bookRoom" method="post">
    Customer:
    <select name="customerId" required>
        <option value="">Select Customer</option>
        <%
            for (Customer c : customers) {
        %>
        <option value="<%= c.getCustomerId() %>">
            <%= c.getCustomerId() %> - <%= c.getName() %>
        </option>
        <%
            }
        %>
    </select>
    <br><br>

    Room:
    <select name="roomId" required>
        <option value="">Select Room</option>
        <%
            for (Room r : rooms) {
        %>
        <option value="<%= r.getRoomId() %>">
            <%= r.getRoomNumber() %> - <%= r.getRoomType() %> - Rs <%= r.getPrice() %>
        </option>
        <%
            }
        %>
    </select>
    <br><br>

    Check In Date: <input type="date" name="checkInDate" required><br><br>
    Check Out Date: <input type="date" name="checkOutDate" required><br><br>

    <input type="submit" value="Book Room">
</form>

<br>
<a href="dashboard.jsp">Back to Dashboard</a>
</body>
</html>