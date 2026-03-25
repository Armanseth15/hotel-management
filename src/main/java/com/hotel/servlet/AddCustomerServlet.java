package com.hotel.servlet;

import com.hotel.dao.CustomerDAO;
import com.hotel.model.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/addCustomer")
public class AddCustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String idProof = request.getParameter("idProof");

        Customer customer = new Customer(name, email, phone, address, idProof);
        CustomerDAO dao = new CustomerDAO();

        if (dao.addCustomer(customer)) {
            response.sendRedirect("bookRoom.jsp");
        } else {
            response.getWriter().println("Failed to add customer");
        }
    }
}