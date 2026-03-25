package com.hotel.servlet;

import com.hotel.dao.BookingDAO;
import com.hotel.dao.PaymentDAO;
import com.hotel.dao.RoomDAO;
import com.hotel.model.Booking;
import com.hotel.model.Payment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookingId = Integer.parseInt(request.getParameter("bookingId"));
        String paymentMethod = request.getParameter("paymentMethod");

        BookingDAO bookingDAO = new BookingDAO();
        RoomDAO roomDAO = new RoomDAO();
        PaymentDAO paymentDAO = new PaymentDAO();

        Booking booking = bookingDAO.getBookingById(bookingId);

        if (booking == null) {
            response.getWriter().println("Booking not found");
            return;
        }

        Payment payment = new Payment();
        payment.setBookingId(bookingId);
        payment.setAmount(booking.getTotalAmount());
        payment.setPaymentDate(LocalDate.now().toString());
        payment.setPaymentMethod(paymentMethod);
        payment.setPaymentStatus("Paid");

        boolean paymentDone = paymentDAO.addPayment(payment);

        if (paymentDone) {
            bookingDAO.updateBookingStatus(bookingId, "Checked Out");
            roomDAO.updateRoomStatus(booking.getRoomId(), "Available");
            response.sendRedirect("bill?bookingId=" + bookingId);
        } else {
            response.getWriter().println("Checkout failed");
        }
    }
}