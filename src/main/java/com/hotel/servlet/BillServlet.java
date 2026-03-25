package com.hotel.servlet;

import com.hotel.dao.BookingDAO;
import com.hotel.dao.PaymentDAO;
import com.hotel.model.Booking;
import com.hotel.model.Payment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/bill")
public class BillServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookingId = Integer.parseInt(request.getParameter("bookingId"));

        BookingDAO bookingDAO = new BookingDAO();
        PaymentDAO paymentDAO = new PaymentDAO();

        Booking booking = bookingDAO.getBookingById(bookingId);
        Payment payment = paymentDAO.getPaymentByBookingId(bookingId);

        request.setAttribute("booking", booking);
        request.setAttribute("payment", payment);

        request.getRequestDispatcher("bill.jsp").forward(request, response);
    }
}