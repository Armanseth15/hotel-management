package com.hotel.servlet;

import com.hotel.dao.BookingDAO;
import com.hotel.dao.RoomDAO;
import com.hotel.model.Booking;
import com.hotel.model.Room;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@WebServlet("/bookRoom")
public class BookRoomServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        String checkInDate = request.getParameter("checkInDate");
        String checkOutDate = request.getParameter("checkOutDate");

        LocalDate inDate = LocalDate.parse(checkInDate);
        LocalDate outDate = LocalDate.parse(checkOutDate);

        long days = ChronoUnit.DAYS.between(inDate, outDate);
        if (days <= 0) {
            response.getWriter().println("Check-out date must be after check-in date");
            return;
        }

        RoomDAO roomDAO = new RoomDAO();
        Room room = roomDAO.getRoomById(roomId);

        if (room == null) {
            response.getWriter().println("Room not found");
            return;
        }

        double total = days * room.getPrice();

        Booking booking = new Booking();
        booking.setCustomerId(customerId);
        booking.setRoomId(roomId);
        booking.setCheckInDate(checkInDate);
        booking.setCheckOutDate(checkOutDate);
        booking.setNoOfDays((int) days);
        booking.setTotalAmount(total);
        booking.setBookingStatus("Booked");

        BookingDAO bookingDAO = new BookingDAO();

        if (bookingDAO.addBooking(booking)) {
            roomDAO.updateRoomStatus(roomId, "Booked");
            response.sendRedirect("viewBookings");
        } else {
            response.getWriter().println("Booking failed");
        }
    }
}