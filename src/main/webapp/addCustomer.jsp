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
    <title>Add Customer</title>
</head>
<body>
<h2>Add Customer</h2>

<form action="addCustomer" method="post">
    Name: <input type="text" name="name" required><br><br>
    Email: <input type="email" name="email"><br><br>
    Phone: <input type="text" name="phone"><br><br>
    Address: <input type="text" name="address"><br><br>
    ID Proof: <input type="text" name="idProof"><br><br>
    <input type="submit" value="Add Customer">
</form>

<br>
<a href="dashboard.jsp">Back to Dashboard</a>
</body>
</html>